package com.oneplatform.organisation.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesuite.common.util.BeanUtils;
import com.jeesuite.springweb.model.WrapperResponse;
import com.oneplatform.base.LoginContext;
import com.oneplatform.base.model.LoginSession;
import com.oneplatform.organisation.dao.entity.DepartmentEntity;
import com.oneplatform.organisation.dto.param.DepartmentParam;
import com.oneplatform.organisation.service.DepartmentService;

import io.swagger.annotations.ApiOperation;

/**
 * generated by www.jeesuite.com
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

private @Autowired DepartmentService departmentService;
	
	@ApiOperation(value = "按id查询")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody WrapperResponse<DepartmentEntity> getById(@PathVariable("id") int id) {
		DepartmentEntity entity = departmentService.findDepartmentById(id);
		return new WrapperResponse<>(entity);
	}
	
	@ApiOperation(value = "新增")
	@RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody WrapperResponse<String> addAccount(@RequestBody DepartmentParam param) {
		DepartmentEntity entity = BeanUtils.copy(param, DepartmentEntity.class);
		LoginSession session = LoginContext.getLoginSession();
		entity.setCreatedAt(new Date());
		entity.setCreatedBy(session.getUserId());
		departmentService.addDepartment(entity);
		
		return new WrapperResponse<>();
	}
	
	@ApiOperation(value = "更新")
	@RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody WrapperResponse<String> updateAccount(@RequestBody DepartmentParam param) {
		DepartmentEntity entity = BeanUtils.copy(param, DepartmentEntity.class);
		LoginSession session = LoginContext.getLoginSession();
		entity.setCreatedAt(new Date());
		entity.setCreatedBy(session.getUserId());
		departmentService.updateDepartment(entity);
		
		return new WrapperResponse<>();
	}
	
	@ApiOperation(value = "删除账户")
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public @ResponseBody WrapperResponse<String> deleteAccount(@PathVariable("id") int id) {
		departmentService.deleteDepartment(id);
		return new WrapperResponse<>();
	}
	
	
}
