package com.bjp.bam_authoritymanagement.vo.authority;

import com.bjp.pojo.FunctionInfo;

public class CFunctionInfo extends FunctionInfo{
	private Integer roleAuthorityId;

	private Boolean checked;

	public Integer getRoleAuthorityId() {
		return roleAuthorityId;
	}
	
	public void setRoleAuthorityId(Integer roleAuthorityId) {
		this.roleAuthorityId = roleAuthorityId;
	}
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}
