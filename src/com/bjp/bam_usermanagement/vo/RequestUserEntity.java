package com.bjp.bam_usermanagement.vo;

import com.bjp.pojo.UserInfo;

public class RequestUserEntity {
	private UserInfo userInfo;
	private Integer familyId;
	private String familyName;
	private Integer extendType;
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Integer getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}
	public Integer getExtendType() {
		return extendType;
	}
	public void setExtendType(Integer extendType) {
		this.extendType = extendType;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
}
