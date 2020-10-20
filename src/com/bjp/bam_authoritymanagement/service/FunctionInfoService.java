package com.bjp.bam_authoritymanagement.service;

import java.util.List;

import com.bjp.pojo.FunctionInfo;

public interface FunctionInfoService {
	List<FunctionInfo> list();
	void add(FunctionInfo record);
	void update(FunctionInfo record);
	void delete(int id);
	FunctionInfo get(int id);
	
	List<FunctionInfo> findAllFunctionInfoByPageInfo(Integer pageId);
}
