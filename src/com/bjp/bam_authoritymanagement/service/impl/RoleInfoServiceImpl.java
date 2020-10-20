package com.bjp.bam_authoritymanagement.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_authoritymanagement.service.RoleInfoService;
import com.bjp.mapper.RoleInfoMapper;
import com.bjp.pojo.RoleInfo;
import com.bjp.pojo.RoleInfoExample;
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
	@Autowired
	RoleInfoMapper roleMapper;
	@Override
	public List<RoleInfo> list() {
		RoleInfoExample example = new RoleInfoExample();
		example.setOrderByClause("id desc");
		return roleMapper.selectByExample(example);
	}

	@Override
	public void add(RoleInfo role) {
		role.setCreateTime(new Date());
		roleMapper.insert(role);
	}

	@Override
	public void update(RoleInfo role) {
		role.setUpdateTime(new Date());
		roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public void delete(int roleId) {
		roleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public RoleInfo get(int roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}
}
