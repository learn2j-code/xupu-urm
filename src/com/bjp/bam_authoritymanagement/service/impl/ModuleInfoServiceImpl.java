package com.bjp.bam_authoritymanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_authoritymanagement.service.ModuleInfoService;
import com.bjp.bam_authoritymanagement.service.PageInfoService;
import com.bjp.mapper.ModuleInfoMapper;
import com.bjp.mapper.PageInfoMapper;
import com.bjp.pojo.ModuleInfo;
import com.bjp.pojo.ModuleInfoExample;
import com.bjp.pojo.PageInfo;
import com.bjp.pojo.PageInfoExample;
@Service
public class ModuleInfoServiceImpl implements ModuleInfoService {
	@Autowired
	ModuleInfoMapper moduleMapper;
	@Override
	public List<ModuleInfo> list() {
		ModuleInfoExample example = new ModuleInfoExample();
		example.setOrderByClause("id desc");
		return moduleMapper.selectByExample(example);
	}

	@Override
	public void add(ModuleInfo record) {
		moduleMapper.insertSelective(record);
	}

	@Override
	public void update(ModuleInfo record) {
		moduleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		moduleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ModuleInfo get(int id) {
		return moduleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ModuleInfo> findAllModuleInfoBySystem(Integer systemId) {
		ModuleInfoExample example = new ModuleInfoExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andSystemIdEqualTo(systemId);
		return moduleMapper.selectByExample(example);
	}

}
