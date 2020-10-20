package com.bjp.bam_authoritymanagement.vo.authority;

import java.util.HashMap;

import com.bjp.pojo.PageInfo;

public class CPageInfo {
	private PageInfo pageInfo;
	private HashMap<Integer,CFunctionInfo> childrenMap;
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public HashMap<Integer, CFunctionInfo> getChildrenMap() {
		return childrenMap;
	}
	public void setChildrenMap(HashMap<Integer, CFunctionInfo> childrenMap) {
		this.childrenMap = childrenMap;
	}
}
