package com.bjp.bam_authoritymanagement.vo.authority;

import java.util.HashMap;

import com.bjp.pojo.SystemInfo;

public class CSystemInfo {
	private SystemInfo systemInfo;
	private HashMap<Integer,CModuleInfo> childrenMap;
	public SystemInfo getSystemInfo() {
		return systemInfo;
	}
	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}
	public HashMap<Integer, CModuleInfo> getChildrenMap() {
		return childrenMap;
	}
	public void setChildrenMap(HashMap<Integer, CModuleInfo> childrenMap) {
		this.childrenMap = childrenMap;
	}
}
