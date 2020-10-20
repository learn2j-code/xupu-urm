package com.bjp.bam_usermanagement.vo;

import java.util.List;

import com.bjp.bam_basemanagement.vo.ResponseEntity;

public class ResponseFamilyManagerEntity extends ResponseEntity {
	private List<FamilyManager> familyManagerList;

	public List<FamilyManager> getFamilyManagerList() {
		return familyManagerList;
	}

	public void setFamilyManagerList(List<FamilyManager> familyManagerList) {
		this.familyManagerList = familyManagerList;
	}

}
