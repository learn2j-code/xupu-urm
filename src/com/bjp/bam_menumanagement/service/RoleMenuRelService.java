package com.bjp.bam_menumanagement.service;

import java.util.List;

import com.bjp.pojo.RoleMenuRel;

public interface RoleMenuRelService {
	List<RoleMenuRel> list();
	void add(RoleMenuRel record);
	void update(RoleMenuRel record);
	void delete(int id);
	RoleMenuRel get(int id);
	List<RoleMenuRel> findRoleMenuRelListByRoleId(int roleId) ;
}
