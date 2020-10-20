package com.bjp.bam_authoritymanagement.service;

import java.util.List;

import com.bjp.pojo.SystemInfo;

public interface SystemInfoService {
	List<SystemInfo> list();
	void add(SystemInfo record);
	void update(SystemInfo record);
	void delete(int id);
	SystemInfo get(int id);
}
