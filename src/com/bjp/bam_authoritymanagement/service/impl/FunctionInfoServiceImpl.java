package com.bjp.bam_authoritymanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_authoritymanagement.service.FunctionInfoService;
import com.bjp.mapper.FunctionInfoMapper;
import com.bjp.pojo.FunctionInfo;
import com.bjp.pojo.FunctionInfoExample;
@Service
public class FunctionInfoServiceImpl implements FunctionInfoService {
	@Autowired
	FunctionInfoMapper functionMapper;
	@Override
	public List<FunctionInfo> list() {
		FunctionInfoExample example = new FunctionInfoExample();
		example.setOrderByClause("id desc");
		return functionMapper.selectByExample(example);
	}

	@Override
	public void add(FunctionInfo record) {
		functionMapper.insertSelective(record);
	}

	@Override
	public void update(FunctionInfo record) {
		functionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		functionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public FunctionInfo get(int id) {
		return functionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<FunctionInfo> findAllFunctionInfoByPageInfo(Integer pageId) {
		FunctionInfoExample example = new FunctionInfoExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andPageIdEqualTo(pageId);
		return functionMapper.selectByExample(example);
	}

}
