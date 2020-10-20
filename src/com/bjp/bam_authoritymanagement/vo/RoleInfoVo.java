package com.bjp.bam_authoritymanagement.vo;

import java.util.List;

import com.bjp.pojo.RoleInfo;
import com.bjp.util.Page;

public class RoleInfoVo {
	private Page page;
	private List<RoleInfo> roleInfoList;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<RoleInfo> getRoleInfoList() {
		return roleInfoList;
	}
	public void setRoleInfoList(List<RoleInfo> roleInfoList) {
		this.roleInfoList = roleInfoList;
	}
}
