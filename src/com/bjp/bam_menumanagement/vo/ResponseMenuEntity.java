package com.bjp.bam_menumanagement.vo;

import java.util.List;

import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.constant.CommonConstant;
import com.bjp.pojo.RoleMenuRel;
import com.bjp.pojo.UserInfo;

public class ResponseMenuEntity extends  ResponseEntity{
	private List<RoleMenuRel> roleMenuRelList;

	public List<RoleMenuRel> getRoleMenuRelList() {
		return roleMenuRelList;
	}

	public void setRoleMenuRelList(List<RoleMenuRel> roleMenuRelList) {
		this.roleMenuRelList = roleMenuRelList;
	}
}
