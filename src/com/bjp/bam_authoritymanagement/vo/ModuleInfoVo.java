package com.bjp.bam_authoritymanagement.vo;

import java.util.List;

import com.bjp.pojo.ModuleInfo;
import com.bjp.util.Page;

public class ModuleInfoVo {
	private Page page;
	private Integer systemId;
	private List<ModuleInfo> moduleInfoList;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	public List<ModuleInfo> getModuleInfoList() {
		return moduleInfoList;
	}
	public void setModuleInfoList(List<ModuleInfo> moduleInfoList) {
		this.moduleInfoList = moduleInfoList;
	}
}
