package com.bjp.bam_usermanagement.vo;

import java.util.List;

import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.pojo.UserInfo;

public class ResponseUserInfoEntity extends ResponseEntity {
	private List<UserInfo> userInfoList;

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}


}
