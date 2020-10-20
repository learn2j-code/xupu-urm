package com.bjp.bam_authoritymanagement.vo.authority;

import java.util.HashMap;

import com.bjp.pojo.RoleInfo;

public class RoleAuthorityVo {
	private RoleInfo roleInfo;
	private HashMap<Integer,CSystemInfo> systemInfoMap;

	public HashMap<Integer, CSystemInfo> getSystemInfoMap() {
		return systemInfoMap;
	}

	public void setSystemInfoMap(HashMap<Integer, CSystemInfo> systemInfoMap) {
		this.systemInfoMap = systemInfoMap;
	}

	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}


	
	
}
