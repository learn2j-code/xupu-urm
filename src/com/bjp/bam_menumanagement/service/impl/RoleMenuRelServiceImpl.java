package com.bjp.bam_menumanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_menumanagement.service.RoleMenuRelService;
import com.bjp.bam_usermanagement.service.UserRelationService;
import com.bjp.mapper.RoleMenuRelMapper;
import com.bjp.mapper.UserRelationMapper;
import com.bjp.pojo.RoleMenuRel;
import com.bjp.pojo.RoleMenuRelExample;
import com.bjp.pojo.UserRelation;
import com.bjp.pojo.UserRelationExample;
@Service
public class RoleMenuRelServiceImpl implements RoleMenuRelService {
	@Autowired
	RoleMenuRelMapper mapper;
	
	@Override
	public List<RoleMenuRel> list() {
		RoleMenuRelExample example = new RoleMenuRelExample();
		example.setOrderByClause("id desc");
		return mapper.selectByExample(example);
	}

	@Override
	public void add(RoleMenuRel record) {
		mapper.insertSelective(record);
	}

	@Override
	public void update(RoleMenuRel record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public RoleMenuRel get(int id) {
		RoleMenuRel userRelation = mapper.selectByPrimaryKey(id);
		return userRelation;
	}

	@Override
	public List<RoleMenuRel> findRoleMenuRelListByRoleId(int roleId) {
		RoleMenuRelExample example = new RoleMenuRelExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.selectByExample(example);
	}
}
