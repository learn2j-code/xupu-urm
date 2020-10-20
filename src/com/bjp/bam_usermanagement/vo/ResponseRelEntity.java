package com.bjp.bam_usermanagement.vo;

import java.util.List;

import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.pojo.UserRelation;

public class ResponseRelEntity extends ResponseEntity {
	private List<UserRelation> relationList;

	public List<UserRelation> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<UserRelation> relationList) {
		this.relationList = relationList;
	}
}
