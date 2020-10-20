package com.bjp.bam_usermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_authoritymanagement.service.RoleInfoService;
import com.bjp.bam_usermanagement.service.UserInfoService;
import com.bjp.mapper.UserInfoMapper;
import com.bjp.pojo.UserInfo;
import com.bjp.pojo.UserInfoExample;
import com.bjp.util.MD5Utils;
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoMapper userMapper;
	@Autowired
	RoleInfoService roleInfoService;
	@Override
	public List<UserInfo> list() {
		UserInfoExample example = new UserInfoExample();
		example.setOrderByClause("id desc");
		return userMapper.selectByExample(example);
	}

	@Override
	public void add(UserInfo user) {
		userMapper.insertSelective(user);
	}

	@Override
	public void update(UserInfo user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void delete(int userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public UserInfo get(int userId) {
		UserInfo userInfo = userMapper.selectByPrimaryKey(userId);
//		userInfo.setRole(roleInfoService.get(userInfo.getRoleId()));
		return userInfo;
	}

	@Override
	public UserInfo findByUserPhone(String phone) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<UserInfo> result = userMapper.selectByExample(example);
		if(result.isEmpty())
			return null;
		return result.get(0);
	}

	@Override
	public List<UserInfo> findAllUserInfoByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		UserInfoExample example = new UserInfoExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andRoleIdEqualTo(roleId);
		return userMapper.selectByExample(example);
	}

	@Override
	public UserInfo findByUserName(String username) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<UserInfo> result = userMapper.selectByExample(example);
		if(result.isEmpty())
			return null;
		return result.get(0);
	}

	@Override
	public boolean addUserInfo(UserInfo user) {
		String password = user.getPassword();
		user.setPassword(MD5Utils.getPwd(password));
		add(user);
		return true;
	}

	@Override
	public List<UserInfo> findUserInfoListByNickname(String nickname) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andNicknameLike("%"+nickname+"%");
		return userMapper.selectByExample(example);
	}

}
