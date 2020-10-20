package com.bjp.bam_usermanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_usermanagement.service.UserInfoService;
import com.bjp.bam_usermanagement.service.UserRelationService;
import com.bjp.bam_usermanagement.vo.FamilyManager;
import com.bjp.mapper.UserRelationMapper;
import com.bjp.pojo.UserInfo;
import com.bjp.pojo.UserRelation;
import com.bjp.pojo.UserRelationExample;
@Service
public class UserRelationServiceImpl implements UserRelationService {
	@Autowired
	UserRelationMapper mapper;
	
	@Autowired
	UserInfoService userInfoService;
	@Override
	public List<UserRelation> list() {
		UserRelationExample example = new UserRelationExample();
		example.setOrderByClause("id desc");
		return mapper.selectByExample(example);
	}

	@Override
	public void add(UserRelation record) {
		mapper.insertSelective(record);
	}

	@Override
	public void update(UserRelation record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int userId) {
		mapper.deleteByPrimaryKey(userId);
	}

	@Override
	public UserRelation get(int userId) {
		UserRelation userRelation = mapper.selectByPrimaryKey(userId);
		return userRelation;
	}

	@Override
	public List<UserRelation> findRelationListByUserId(int id,int relationType) {
		UserRelationExample example = new UserRelationExample();
		example.createCriteria().andUserIdEqualTo(id).andRelationTypeEqualTo(relationType);
		return mapper.selectByExample(example);
	}

	@Override
	public List<UserRelation> findRelationListByRelId(int id,int relationType) {
		UserRelationExample example = new UserRelationExample();
		example.createCriteria().andRelIdEqualTo(id).andRelationTypeEqualTo(relationType);
		return mapper.selectByExample(example);
	}

	@Override
	public List<FamilyManager> findFamilyManagerListByFamilyId(int id, int relationType) {
		List<FamilyManager> familyManagerList = new ArrayList<FamilyManager>();
		List<UserRelation> relationList = findRelationListByRelId(id,1);
		for(UserRelation userRelation:relationList){
			FamilyManager familyManager = new FamilyManager();
			BeanUtils.copyProperties(userRelation, familyManager);
			Integer userId = familyManager.getUserId();
			UserInfo userInfo = userInfoService.get(userId);
			if(userInfo!=null){
				familyManager.setNickname(userInfo.getNickname());
				familyManager.setPhone(userInfo.getPhone());
			}
			familyManagerList.add(familyManager);
		}
		return familyManagerList;
	}

	@Override
	public void deleteRelationListByUserId(int id, int relationType) {
		List<UserRelation> relationList = findRelationListByUserId(id, relationType);
		for(UserRelation userRelation:relationList){
			delete(userRelation.getId());
		}
	}

	@Override
	public void deleteRelationListByFamilyId(int id) {
		UserRelationExample example = new UserRelationExample();
		example.createCriteria().andRelationTypeEqualTo(1).andRelIdEqualTo(id);
		List<UserRelation> relationList = mapper.selectByExample(example);
		for(UserRelation userRelation:relationList){
			delete(userRelation.getId());
		}
	}

	@Override
	public List<FamilyManager> findFamilyManagerListByNameAndFamilyId(int id, int relationType, String userName) {
		List<FamilyManager> familyManagerList = new ArrayList<FamilyManager>();
		List<UserRelation> relationList = findRelationListByRelIdAndUserName(id,1,userName);
		for(UserRelation userRelation:relationList){
			FamilyManager familyManager = new FamilyManager();
			BeanUtils.copyProperties(userRelation, familyManager);
			Integer userId = familyManager.getUserId();
			UserInfo userInfo = userInfoService.get(userId);
			if(userInfo!=null){
				familyManager.setNickname(userRelation.getUserName());
				familyManager.setPhone(userInfo.getPhone());
			}
			familyManagerList.add(familyManager);
		}
		return familyManagerList;
	}

	@Override
	public List<UserRelation> findRelationListByRelIdAndUserName(int id, int relationType, String userName) {
		UserRelationExample example = new UserRelationExample();
		example.createCriteria().andRelIdEqualTo(id).andRelationTypeEqualTo(relationType).andUserNameLike("%"+userName+"%");
		return mapper.selectByExample(example);
	}
}
