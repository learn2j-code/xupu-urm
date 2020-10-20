package com.bjp.bam_authoritymanagement.service;


import com.bjp.pojo.FunctionInfo;
import com.bjp.pojo.ModuleInfo;
import com.bjp.pojo.PageInfo;
import com.bjp.pojo.RoleInfo;
import com.bjp.pojo.SystemInfo;

public interface AuthorityCommonService {
	void addRoleAuthorityWhenAddFunction(FunctionInfo functionInfo);
	void addRoleAuthorityWhenAddRoleInfo(RoleInfo roleInfo);
	void deleteRoleAuthorityWhenDeleteRoleInfo(Integer roleId);
	void deleteRoleAuthorityWhenDeleteFunctionInfo(Integer functionId);
	
	void updateRoleAuthorityWhenUpdateSystemInfo(SystemInfo requestEntity);
	void updateRoleAuthorityWhenUpdateModuleInfo(ModuleInfo requestEntity);
	void updateRoleAuthorityWhenUpdatePageInfo(PageInfo requestEntity);
	void updateRoleAuthorityWhenUpdateFunctionInfo(FunctionInfo requestEntity);
}
