package com.bjp.bam_authoritymanagement.vo;

import java.util.List;

import com.bjp.pojo.PageInfo;
import com.bjp.util.Page;

public class PageInfoVo {
	private Page page;
	private Integer moduleId;
	private List<PageInfo> pageInfoList;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public List<PageInfo> getPageInfoList() {
		return pageInfoList;
	}
	public void setPageInfoList(List<PageInfo> pageInfoList) {
		this.pageInfoList = pageInfoList;
	}
}
