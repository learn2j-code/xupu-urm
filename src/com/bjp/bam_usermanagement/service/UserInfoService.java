package com.bjp.bam_usermanagement.service;

import java.util.List;

import com.bjp.pojo.UserInfo;

public interface UserInfoService {
	List<UserInfo> list();
	void add(UserInfo user);
	void update(UserInfo user);
	void delete(int userId);
	UserInfo get(int userId);
	UserInfo findByUserPhone(String phone);
	UserInfo findByUserName(String username);
	List<UserInfo> findAllUserInfoByRoleId(Integer roleId);
	//根据昵称模糊查询用户列表
	List<UserInfo> findUserInfoListByNickname(String nickname);
	
	boolean addUserInfo(UserInfo user);
}
