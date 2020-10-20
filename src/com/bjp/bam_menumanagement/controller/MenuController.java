package com.bjp.bam_menumanagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bjp.bam_menumanagement.service.RoleMenuRelService;
import com.bjp.bam_menumanagement.vo.ResponseMenuEntity;
import com.bjp.bam_usermanagement.service.UserInfoService;
import com.bjp.pojo.RoleMenuRel;
import com.bjp.pojo.UserInfo;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	RoleMenuRelService roleMenuRelService;
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping("findRoleMenuRelListByUserId")
	public @ResponseBody ResponseMenuEntity findRoleMenuRelListByUserId(@RequestBody UserInfo requestEntity){
		ResponseMenuEntity responseMenuEntity = new ResponseMenuEntity();
		UserInfo userInfo = userInfoService.get(requestEntity.getId());
		List<RoleMenuRel> roleMenuRelList = roleMenuRelService.findRoleMenuRelListByRoleId(userInfo.getRoleId());
		responseMenuEntity.setRoleMenuRelList(roleMenuRelList);
		return responseMenuEntity;
	}
	
}
