package com.bjp.bam_usermanagement.vo;

import com.bjp.pojo.UserRelation;

public class FamilyManager extends UserRelation{
	private String nickname;
	
	/** 手机号码*/
    private String phone;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
