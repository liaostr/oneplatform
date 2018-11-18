package com.oneplatform.organisation.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeesuite.common.util.BeanUtils;
import com.jeesuite.mybatis.plugin.pagination.Page;
import com.jeesuite.mybatis.plugin.pagination.PageExecutor;
import com.jeesuite.mybatis.plugin.pagination.PageExecutor.PageDataLoader;
import com.jeesuite.mybatis.plugin.pagination.PageParams;
import com.oneplatform.base.exception.AssertUtil;
import com.oneplatform.base.model.PageResult;
import com.oneplatform.organisation.dao.entity.DepartmentEntity;
import com.oneplatform.organisation.dao.mapper.DepartmentEntityMapper;

/**
 * generated by www.jeesuite.com
 */
@Service
public class DepartmentService {

	@Autowired
	private DepartmentEntityMapper departmentMapper;

	public void addDepartment(DepartmentEntity entity) {
		departmentMapper.insertSelective(entity);
	}

	public void updateDepartment(DepartmentEntity entity) {
		DepartmentEntity originEntity = departmentMapper.selectByPrimaryKey(entity.getId());
		AssertUtil.notNull(originEntity);
		BeanUtils.copy(entity, originEntity);
		departmentMapper.updateByPrimaryKey(originEntity);
	}
	
	public void deleteDepartment(Integer id) {
		departmentMapper.deleteByPrimaryKey(id);
	}
	
	public DepartmentEntity findDepartmentById(Integer id){
		DepartmentEntity entity = departmentMapper.selectByPrimaryKey(id);
		AssertUtil.notNull(entity);
		return entity;
	}


}
