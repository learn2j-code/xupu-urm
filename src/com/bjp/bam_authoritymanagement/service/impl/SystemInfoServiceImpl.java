package com.bjp.bam_authoritymanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_authoritymanagement.service.SystemInfoService;
import com.bjp.mapper.SystemInfoMapper;
import com.bjp.pojo.SystemInfo;
import com.bjp.pojo.SystemInfoExample;
@Service
public class SystemInfoServiceImpl implements SystemInfoService {
	@Autowired
	SystemInfoMapper mapper;
	@Override
	public List<SystemInfo> list() {
		SystemInfoExample example = new SystemInfoExample();
		example.setOrderByClause("id desc");
		return mapper.selectByExample(example);
	}

	@Override
	public void add(SystemInfo record) {
		mapper.insertSelective(record);
	}

	@Override
	public void update(SystemInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public SystemInfo get(int id) {
		return mapper.selectByPrimaryKey(id);
	}

}
