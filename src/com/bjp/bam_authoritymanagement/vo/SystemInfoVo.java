package com.bjp.bam_authoritymanagement.vo;

import java.util.List;

import com.bjp.pojo.SystemInfo;
import com.bjp.util.Page;

public class SystemInfoVo {
	private Page page;
	private List<SystemInfo> systemInfoList;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<SystemInfo> getSystemInfoList() {
		return systemInfoList;
	}
	public void setSystemInfoList(List<SystemInfo> systemInfoList) {
		this.systemInfoList = systemInfoList;
	}
}
