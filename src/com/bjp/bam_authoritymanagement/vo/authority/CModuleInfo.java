package com.bjp.bam_authoritymanagement.vo.authority;

import java.util.HashMap;

import com.bjp.pojo.ModuleInfo;

public class CModuleInfo {
	private ModuleInfo moduleInfo;
	private HashMap<Integer,CPageInfo> childrenMap;
	public ModuleInfo getModuleInfo() {
		return moduleInfo;
	}
	public void setModuleInfo(ModuleInfo moduleInfo) {
		this.moduleInfo = moduleInfo;
	}
	public HashMap<Integer, CPageInfo> getChildrenMap() {
		return childrenMap;
	}
	public void setChildrenMap(HashMap<Integer, CPageInfo> childrenMap) {
		this.childrenMap = childrenMap;
	}
}
