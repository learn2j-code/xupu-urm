package com.bjp.bam_usermanagement.vo;

import java.util.List;

import com.bjp.pojo.UserInfo;
import com.bjp.util.Page;

public class UserInfoVo {
	private UserInfo user;
	private Integer userId;
	private Integer roleId;
	private Page page;
	private List<UserInfo> userInfoList;
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
