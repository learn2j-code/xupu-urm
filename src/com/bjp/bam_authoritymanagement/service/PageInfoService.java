package com.bjp.bam_authoritymanagement.service;

import java.util.List;

import com.bjp.pojo.PageInfo;

public interface PageInfoService {
	List<PageInfo> list();
	void add(PageInfo record);
	void update(PageInfo record);
	void delete(int id);
	PageInfo get(int id);
	
	List<PageInfo> findAllPageInfoByModule(Integer moduleId);
}
