package com.oneplatform.organisation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeesuite.common.JeesuiteBaseException;
import com.jeesuite.common.util.BeanUtils;
import com.oneplatform.base.exception.AssertUtil;
import com.oneplatform.base.exception.ExceptionCode;
import com.oneplatform.base.model.TreeModel;
import com.oneplatform.organisation.dao.entity.CompanyEntity;
import com.oneplatform.organisation.dao.entity.DepartmentEntity;
import com.oneplatform.organisation.dao.mapper.CompanyEntityMapper;
import com.oneplatform.organisation.dao.mapper.DepartmentEntityMapper;

/**
 * generated by www.jeesuite.com
 */
@Service
public class CompanyService {

	private @Autowired CompanyEntityMapper companyMapper;
	private @Autowired DepartmentEntityMapper departmentMapper;

	public void addCompany(CompanyEntity entity) {
		companyMapper.insertSelective(entity);
	}

	public void updateCompany(CompanyEntity entity) {
		CompanyEntity originEntity = companyMapper.selectByPrimaryKey(entity.getId());
		AssertUtil.notNull(originEntity);
		BeanUtils.copy(entity, originEntity);
		originEntity.setIsBranch(false);
		companyMapper.updateByPrimaryKey(originEntity);
	}
	
	public void deleteCompany(Integer id) {
		CompanyEntity entity = companyMapper.selectByPrimaryKey(id);
		AssertUtil.notNull(entity);
		if(!entity.getIsBranch()){
			throw new JeesuiteBaseException(ExceptionCode.OPTER_NOT_ALLOW.code, "分公司才能删除");
		}
		entity.setInActive(false);
		companyMapper.updateByPrimaryKeySelective(entity);
	}
	
	public CompanyEntity findHeadCompany(){
		CompanyEntity entity = companyMapper.findHeadCompany();
		return entity;
	}
	
	public TreeModel findStructureTree(){
		TreeModel root = new TreeModel();
		List<CompanyEntity> companys =  companyMapper.findAllCompany();
		if(companys.isEmpty()){
			root.setId(0);
			root.setName("总公司");
		}else{
			Map<Integer, TreeModel> modelMapping = new HashMap<>();
			root.setId(companys.get(0).getId());
			root.setName(companys.get(0).getName());
			root.setOriginData(companys.get(0));
			modelMapping.put(0, root);
			TreeModel branch;
			for (int i = 1; i < companys.size(); i++) {
				branch = new TreeModel(companys.get(i).getId(), companys.get(i).getName(), null, null, root.getPid(), false);
				branch.setOriginData(companys.get(i));
				branch.setExtraAttr("company");
				root.addChild(branch);
				modelMapping.put(branch.getId(), branch);
			}
			//
			List<DepartmentEntity> departments = departmentMapper.selectAll();
			TreeModel departModel;
			TreeModel parentModel;
			for (DepartmentEntity d : departments) {
				if(!d.getInActive())continue;
				parentModel = modelMapping.get(d.getBranchId());
				departModel = new TreeModel(d.getId(), d.getName(), null, null, parentModel.getId(), true);
				departModel.setOriginData(d);
				departModel.setExtraAttr("department");
				parentModel.addChild(departModel);
			}
		}
		root.setExtraAttr("company");
		
		return root;
	}
	

	public CompanyEntity findCompanyById(Integer id){
		CompanyEntity entity = companyMapper.selectByPrimaryKey(id);
		AssertUtil.notNull(entity);
		return entity;
	}


}
