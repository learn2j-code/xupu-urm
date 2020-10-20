package com.bjp.bam_authoritymanagement.service;

import java.util.List;

import com.bjp.bam_authoritymanagement.vo.authority.RoleAuthorityVo;
import com.bjp.pojo.FunctionInfo;
import com.bjp.pojo.RoleAuthority;

public interface RoleAuthorityService {
	List<RoleAuthority> list();
	void add(RoleAuthority record);
	void update(RoleAuthority record);
	void delete(int id);
	RoleAuthority get(int id);
	
	List<RoleAuthority> findRoleAuthorityListByRoleId(Integer roleId);
	RoleAuthorityVo findRoleAuthorityByRoleId(Integer roleId);
	
	List<RoleAuthority> findRoleAuthorityListBySystemId(Integer systemId);
	List<RoleAuthority> findRoleAuthorityListByModuleId(Integer moduleId);
	List<RoleAuthority> findRoleAuthorityListByPageId(Integer pageId);
	List<RoleAuthority> findRoleAuthorityListByFunctionId(Integer functionId);
}
