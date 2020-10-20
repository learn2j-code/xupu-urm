package com.bjp.bam_authoritymanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjp.bam_authoritymanagement.service.AuthorityCommonService;
import com.bjp.bam_authoritymanagement.service.FunctionInfoService;
import com.bjp.bam_authoritymanagement.service.ModuleInfoService;
import com.bjp.bam_authoritymanagement.service.PageInfoService;
import com.bjp.bam_authoritymanagement.service.RoleAuthorityService;
import com.bjp.bam_authoritymanagement.service.RoleInfoService;
import com.bjp.bam_authoritymanagement.service.SystemInfoService;
import com.bjp.pojo.FunctionInfo;
import com.bjp.pojo.ModuleInfo;
import com.bjp.pojo.PageInfo;
import com.bjp.pojo.RoleAuthority;
import com.bjp.pojo.RoleInfo;
import com.bjp.pojo.SystemInfo;
@Service
public class AuthorityCommonServiceImpl implements AuthorityCommonService {

	@Autowired
	FunctionInfoService functionInfoService;
	@Autowired
	ModuleInfoService moduleInfoService;
	@Autowired
	PageInfoService pageInfoService;
	@Autowired
	RoleInfoService roleInfoService;
	@Autowired
	SystemInfoService systemInfoService;
	@Autowired
	RoleAuthorityService roleAuthorityService;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void addRoleAuthorityWhenAddFunction(FunctionInfo functionInfo) {
		functionInfoService.add(functionInfo);
		
		Integer pageId = functionInfo.getPageId();
		if(pageId==null){
			return;
		}
		PageInfo pageInfo = pageInfoService.get(pageId);
		
		Integer moduleId = pageInfo.getModuleId();
		ModuleInfo moduleInfo = moduleInfoService.get(moduleId);
		Integer systemId = moduleInfo.getSystemId();
		SystemInfo systemInfo = systemInfoService.get(systemId);
		
		String systemName = systemInfo.getSystemName();
		String systemAddress = systemInfo.getSystemAddress();
		
		String moduleName = moduleInfo.getModuleName();
		
		String pageName = pageInfo.getPageName();
		
		Integer functionId = functionInfo.getId();
		String functionName = functionInfo.getFunctionName();
		String functionAddress = functionInfo.getFunctionAddress();
		
		List<RoleInfo> roleInfoList = roleInfoService.list();
		for(RoleInfo roleInfo:roleInfoList){
			Integer roleId = roleInfo.getId();
			RoleAuthority roleAuthority = new RoleAuthority();
			roleAuthority.setFunctionAddress(functionAddress);
			roleAuthority.setFunctionId(functionId);
			roleAuthority.setFunctionName(functionName);
			roleAuthority.setModuleId(moduleId);
			roleAuthority.setModuleName(moduleName);
			roleAuthority.setPageId(pageId);
			roleAuthority.setPageName(pageName);
			roleAuthority.setSystemAddress(systemAddress);
			roleAuthority.setSystemName(systemName);
			roleAuthority.setSystemId(systemId);
			roleAuthority.setBannedFlag(1);
			roleAuthority.setRoleId(roleId);
			roleAuthorityService.add(roleAuthority);
		}
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void addRoleAuthorityWhenAddRoleInfo(RoleInfo roleInfo) {
		List<RoleInfo> roleInfoList = roleInfoService.list();
		roleInfoService.add(roleInfo);
		if(roleInfoList.size()>0){
			RoleInfo otherRoleInfo = roleInfoList.get(0);
			List<RoleAuthority> roleAuthorityList = roleAuthorityService.findRoleAuthorityListByRoleId(otherRoleInfo.getId());
			for(RoleAuthority otherRoleAuthority:roleAuthorityList){
				RoleAuthority roleAuthority = new RoleAuthority();
				roleAuthority.setFunctionAddress(otherRoleAuthority.getFunctionAddress());
				roleAuthority.setFunctionId(otherRoleAuthority.getFunctionId());
				roleAuthority.setFunctionName(otherRoleAuthority.getFunctionName());
				roleAuthority.setModuleId(otherRoleAuthority.getModuleId());
				roleAuthority.setModuleName(otherRoleAuthority.getModuleName());
				roleAuthority.setPageId(otherRoleAuthority.getPageId());
				roleAuthority.setPageName(otherRoleAuthority.getPageName());
				roleAuthority.setSystemAddress(otherRoleAuthority.getSystemAddress());
				roleAuthority.setSystemName(otherRoleAuthority.getSystemName());
				roleAuthority.setSystemId(otherRoleAuthority.getSystemId());
				roleAuthority.setBannedFlag(1);
				roleAuthority.setRoleId(roleInfo.getId());
				roleAuthorityService.add(roleAuthority);
			}
		}
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void deleteRoleAuthorityWhenDeleteRoleInfo(Integer roleId) {
		roleInfoService.delete(roleId);
		List<RoleAuthority> roleAuthorityList = roleAuthorityService.findRoleAuthorityListByRoleId(roleId);
		for(RoleAuthority roleAuthority:roleAuthorityList){
			roleAuthorityService.delete(roleAuthority.getId());
		}
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void updateRoleAuthorityWhenUpdateSystemInfo(SystemInfo requestEntity) {
		systemInfoService.update(requestEntity);
		List<RoleAuthority> roleAuthorityList = roleAuthorityService.findRoleAuthorityListBySystemId(requestEntity.getId());
		for(RoleAuthority roleAuthority:roleAuthorityList){
			roleAuthority.setSystemAddress(requestEntity.getSystemAddress());
			roleAuthority.setSystemName(requestEntity.getSystemName());
			roleAuthorityService.update(roleAuthority);
		}
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void updateRoleAuthorityWhenUpdateModuleInfo(ModuleInfo requestEntity) {
		moduleInfoService.update(requestEntity);
		List<RoleAuthority> roleAuthorityList = roleAuthorityService.findRoleAuthorityListByModuleId(requestEntity.getId());
		for(RoleAuthority roleAuthority:roleAuthorityList){
			roleAuthority.setModuleName(requestEntity.getModuleName());
			roleAuthorityService.update(roleAuthority);
		}
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void updateRoleAuthorityWhenUpdatePageInfo(PageInfo requestEntity) {
		pageInfoService.update(requestEntity);
		List<RoleAuthority> roleAuthorityList = roleAuthorityService.findRoleAuthorityListByPageId(requestEntity.getId());
		for(RoleAuthority roleAuthority:roleAuthorityList){
			roleAuthority.setPageName(requestEntity.getPageName());
			roleAuthorityService.update(roleAuthority);
		}
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void updateRoleAuthorityWhenUpdateFunctionInfo(FunctionInfo requestEntity) {
		functionInfoService.update(requestEntity);
		List<RoleAuthority> roleAuthorityList = roleAuthorityService.findRoleAuthorityListByFunctionId(requestEntity.getId());
		for(RoleAuthority roleAuthority:roleAuthorityList){
			roleAuthority.setFunctionName(requestEntity.getFunctionName());
			roleAuthority.setFunctionAddress(requestEntity.getFunctionAddress());
			roleAuthorityService.update(roleAuthority);
		}
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void deleteRoleAuthorityWhenDeleteFunctionInfo(Integer functionId) {
		functionInfoService.delete(functionId);
		List<RoleAuthority> roleAuthorityList = roleAuthorityService.findRoleAuthorityListByFunctionId(functionId);
		for(RoleAuthority roleAuthority:roleAuthorityList){
			roleAuthorityService.delete(roleAuthority.getId());
		}
	}

	
}
