package com.bjp.bam_usermanagement.service;

import java.util.List;

import com.bjp.bam_usermanagement.vo.FamilyManager;
import com.bjp.pojo.UserRelation;

public interface UserRelationService {
	List<UserRelation> list();
	void add(UserRelation record);
	void update(UserRelation record);
	void delete(int id);
	UserRelation get(int id);
	List<UserRelation> findRelationListByUserId(int id,int relationType);
	List<UserRelation> findRelationListByRelId(int id,int relationType);
	
	//查询家族管理员列表通过家族id和关系类型
	List<FamilyManager> findFamilyManagerListByFamilyId(int id,int relationType);
	//查询家族管理员列表通过用户名、家族id和关系类型
	List<FamilyManager> findFamilyManagerListByNameAndFamilyId(int id,int relationType,String userName);
	List<UserRelation> findRelationListByRelIdAndUserName(int id,int relationType,String userName);
	
	void deleteRelationListByUserId(int id,int relationType);
	
	void deleteRelationListByFamilyId(int id);
}
