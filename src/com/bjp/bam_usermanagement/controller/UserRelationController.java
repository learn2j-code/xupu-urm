package com.bjp.bam_usermanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.bam_usermanagement.service.UserRelationService;
import com.bjp.bam_usermanagement.vo.FamilyManager;
import com.bjp.bam_usermanagement.vo.ResponseFamilyManagerEntity;
import com.bjp.bam_usermanagement.vo.ResponseRelEntity;
import com.bjp.constant.CommonConstant;
import com.bjp.pojo.UserRelation;

@Controller
@RequestMapping("")
public class UserRelationController {
	@Autowired
	UserRelationService userRelationService;
	
	@RequestMapping("addUserRelation")
	public @ResponseBody ResponseEntity addUserRelation(@RequestBody UserRelation requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("不能为空");
			return response;
		}
		
		userRelationService.add(requestEntity);
		return response;
	}	
	
	@RequestMapping("findFamilyListByUserId")
	public @ResponseBody ResponseRelEntity findFamilyListByUserId(@RequestBody UserRelation requestEntity){
		ResponseRelEntity response= new ResponseRelEntity();
		List<UserRelation> relationList = userRelationService.findRelationListByUserId(requestEntity.getUserId(),1);
		response.setRelationList(relationList);
		return response;
	}
	
	@RequestMapping("findFamilyManagerListByFamilyId")
	public @ResponseBody ResponseFamilyManagerEntity findFamilyManagerListByFamilyId(@RequestBody UserRelation requestEntity){
		ResponseFamilyManagerEntity response= new ResponseFamilyManagerEntity();
		List<FamilyManager> familyManagerList = userRelationService.findFamilyManagerListByFamilyId(requestEntity.getRelId(),1);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("familyManagerList", familyManagerList);
		response.setData(data);
		return response;
	}
	
	@RequestMapping("findFamilyManagerListByNameAndFamilyId")
	public @ResponseBody ResponseFamilyManagerEntity findFamilyManagerListByNameAndFamilyId(@RequestBody UserRelation requestEntity){
		ResponseFamilyManagerEntity response= new ResponseFamilyManagerEntity();
		List<FamilyManager> familyManagerList = userRelationService.findFamilyManagerListByNameAndFamilyId(requestEntity.getRelId(),1,requestEntity.getUserName());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("familyManagerList", familyManagerList);
		response.setData(data);
		return response;
	}
	
	@RequestMapping("findUserListByRelId")
	public @ResponseBody ResponseRelEntity findUserListByRelId(@RequestBody UserRelation requestEntity){
		ResponseRelEntity response= new ResponseRelEntity();
		List<UserRelation> relationList = userRelationService.findRelationListByRelId(requestEntity.getRelId(),1);
		response.setRelationList(relationList);
		return response;
	}
	
	@RequestMapping("deleteRelationListByFamilyId")
	public @ResponseBody ResponseFamilyManagerEntity deleteRelationListByFamilyId(@RequestBody UserRelation requestEntity){
		ResponseFamilyManagerEntity response= new ResponseFamilyManagerEntity();
		try {
			userRelationService.deleteRelationListByFamilyId(requestEntity.getRelId());
		} catch (Exception e) {
			response.setSuccess(CommonConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getMessage());
		}
		return response;
	}
}
