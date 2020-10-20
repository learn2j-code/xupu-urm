package com.bjp.bam_authoritymanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_authoritymanagement.service.PageInfoService;
import com.bjp.mapper.PageInfoMapper;
import com.bjp.pojo.PageInfo;
import com.bjp.pojo.PageInfoExample;
@Service
public class PageInfoServiceImpl implements PageInfoService {
	@Autowired
	PageInfoMapper pageMapper;
	@Override
	public List<PageInfo> list() {
		PageInfoExample example = new PageInfoExample();
		example.setOrderByClause("id desc");
		return pageMapper.selectByExample(example);
	}

	@Override
	public void add(PageInfo record) {
		pageMapper.insertSelective(record);
	}

	@Override
	public void update(PageInfo record) {
		pageMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		pageMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo get(int id) {
		return pageMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PageInfo> findAllPageInfoByModule(Integer moduleId) {
		PageInfoExample example = new PageInfoExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andModuleIdEqualTo(moduleId);
		return pageMapper.selectByExample(example);
	}

}
