package com.bjp.bam_authoritymanagement.vo;

import java.util.List;

import com.bjp.pojo.FunctionInfo;
import com.bjp.util.Page;

public class FunctionInfoVo {
	private Page page;
	private Integer pageId;
	private List<FunctionInfo> functionInfoList;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<FunctionInfo> getFunctionInfoList() {
		return functionInfoList;
	}
	public void setFunctionInfoList(List<FunctionInfo> functionInfoList) {
		this.functionInfoList = functionInfoList;
	}
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
