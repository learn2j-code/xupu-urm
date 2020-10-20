package com.bjp.bam_authoritymanagement.service;

import java.util.List;

import com.bjp.pojo.ModuleInfo;

public interface ModuleInfoService {
	List<ModuleInfo> list();
	void add(ModuleInfo record);
	void update(ModuleInfo record);
	void delete(int id);
	ModuleInfo get(int id);
	
	List<ModuleInfo> findAllModuleInfoBySystem(Integer systemId);
}
