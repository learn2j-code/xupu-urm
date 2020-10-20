package com.bjp.bam_usermanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjp.bam_authoritymanagement.service.RoleAuthorityService;
import com.bjp.bam_authoritymanagement.service.RoleInfoService;
import com.bjp.bam_authoritymanagement.vo.authority.RoleAuthorityVo;
import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.bam_usermanagement.service.UserInfoService;
import com.bjp.bam_usermanagement.service.UserRelationService;
import com.bjp.bam_usermanagement.vo.FamilyManager;
import com.bjp.bam_usermanagement.vo.RequestUserEntity;
import com.bjp.bam_usermanagement.vo.ResponseUserInfoEntity;
import com.bjp.bam_usermanagement.vo.UserInfoVo;
import com.bjp.constant.RoleConstant;
import com.bjp.pojo.RoleInfo;
import com.bjp.pojo.UserInfo;
import com.bjp.pojo.UserRelation;
import com.bjp.util.MD5Utils;
import com.bjp.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("")
public class UserInfoController {
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	RoleAuthorityService roleAuthorityService;
	@Autowired
	RoleInfoService roleInfoService;
	@Autowired
	UserRelationService userRelationService;
	@RequestMapping("user")
	public ModelAndView listCategory(){
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("findByUserPhone")
	public @ResponseBody ResponseEntity findByUserPhone(@RequestBody UserInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("user==null");
			return response;
		}

		//通过电话号码查询
		UserInfo user = userInfoService.findByUserPhone(requestEntity.getPhone());
		UserInfo userInfo = new UserInfo();
		if(user!=null){
			userInfo.setId(user.getId());
			userInfo.setNickname(user.getNickname());
		}
		response.setUserInfo(userInfo);
		return response;
	}
	
	@RequestMapping("userPhoneLogin")
	public @ResponseBody ResponseEntity userPhoneLogin(@RequestBody UserInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("user==null");
			return response;
		}

		//通过电话号码查询
		UserInfo user = userInfoService.findByUserPhone(requestEntity.getPhone());
		if(user==null){
			response.setSuccess(0);
			response.setErrorMsg("用户不存在!");
			return response;
		}
		if(!user.getPassword().equals(MD5Utils.getPwd(requestEntity.getPassword()))){
			response.setSuccess(0);
			response.setErrorMsg("用户密码错误!");
			return response;
		}
		UserInfo userInfo = new UserInfo();
		userInfo.setId(user.getId());
		userInfo.setNickname(user.getNickname());
		response.setUserInfo(userInfo);
		return response;
	}
	
	@RequestMapping("userAccountLogin")
	public @ResponseBody ResponseEntity userAccountLogin(@RequestBody UserInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("user==null");
			return response;
		}

		//通过电话号码查询
		UserInfo user = userInfoService.findByUserName(requestEntity.getUsername());
		if(user==null){
			response.setSuccess(0);
			response.setErrorMsg("用户不存在!");
			return response;
		}
		if(!user.getPassword().equals(MD5Utils.getPwd(requestEntity.getPassword()))){
			response.setSuccess(0);
			response.setErrorMsg("用户密码错误!");
			return response;
		}
		UserInfo userInfo = new UserInfo();
		userInfo.setId(user.getId());
		userInfo.setNickname(user.getNickname());
		response.setUserInfo(userInfo);
		return response;
	}
	@RequestMapping("userRegister")
	public @ResponseBody ResponseEntity userRegister(@RequestBody UserInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
//		if(requestEntity==null){
//			response.setSuccess(0);
//			response.setErrorMsg("user==null");
//			return response;
//		}
//		userInfoService.add(requestEntity);
		
		return response;
	}	
	
	
	@RequestMapping("findAllUserInfo")
    public @ResponseBody UserInfoVo findAllUserInfo(@RequestBody UserInfoVo requestEntity){
    	//分页参数设置
    	Page page = requestEntity.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	
    	List<UserInfo> userInfoList = userInfoService.list();
		int total = (int)new PageInfo<>(userInfoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		requestEntity.setUserInfoList(userInfoList);
		requestEntity.setPage(page);
        return requestEntity;
    }
	
	@RequestMapping("findAllUserInfoByRoleId")
    public @ResponseBody UserInfoVo findAllUserInfoByRoleId(@RequestBody UserInfoVo requestEntity){
    	//分页参数设置
    	Page page = requestEntity.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	
    	List<UserInfo> userInfoList = userInfoService.findAllUserInfoByRoleId(requestEntity.getRoleId());
		int total = (int)new PageInfo<>(userInfoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		requestEntity.setUserInfoList(userInfoList);
		requestEntity.setPage(page);
        return requestEntity;
    }
	
	@RequestMapping("findUserInfoById")
    public @ResponseBody UserInfo findUserInfoById(@RequestBody UserInfo requestEntity){
        return userInfoService.get(requestEntity.getId());
    }
	
	@RequestMapping("addUserInfo")
	public @ResponseBody ResponseEntity addUserInfo(@RequestBody UserInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("角色参数不能为空");
			return response;
		}
		//新增用户的时候判断手机号是否重复
		if(null!=userInfoService.findByUserPhone(requestEntity.getPhone())){
			response.setSuccess(0);
			response.setErrorMsg("用户手机号重复");
			return response;
		}
		//新增用户的时候判断用户名是否重复
		if(null!=userInfoService.findByUserName(requestEntity.getUsername())){
			response.setSuccess(0);
			response.setErrorMsg("用户账号重复");
			return response;
		}
		
		userInfoService.addUserInfo(requestEntity);
		UserInfo userInfo = new UserInfo();
		userInfo.setId(requestEntity.getId());
		userInfo.setNickname(requestEntity.getNickname());
		response.setUserInfo(userInfo);
		
		return response;
	}	
	
	//添加家族管理员
	@RequestMapping("addFamilyManagerInfo")
	public @ResponseBody ResponseEntity addFamilyManagerInfo(@RequestBody RequestUserEntity requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("参数不能为空");
			return response;
		}
		UserInfo requestUser = requestEntity.getUserInfo();
		Integer userId = 0; 
		String userName = null;
		requestUser.setRoleId(RoleConstant.FAMILY_MANAGE); //家族管理员角色id 暂时固定
		UserInfo user = userInfoService.findByUserPhone(requestEntity.getUserInfo().getPhone());
		//如果用户不存在，则新增用户
		if(null==user){
			userInfoService.addUserInfo(requestUser);
			userId = requestUser.getId();
			userName = requestUser.getNickname();
		}else{
			//如果是族谱管理员用户，则添加用户和家族的关系，否则提示用户该手机号已绑定叙谱其他平台，联系客服解绑后才能使用
			if(user.getRoleId()!=RoleConstant.FAMILY_MANAGE){
				response.setSuccess(0);
				response.setErrorMsg("用户该手机号已绑定叙谱其他平台，联系客服解绑后才能使用");
				return response;
			}else{
				userId = user.getId();
				userName = user.getNickname();
			}
		}
				
//		//先删除原有的关系再添加
//		userRelationService.DeleteRelationListByUserId(userId, 1);
		//添加用户与家族的关系
		UserRelation userRelation = new UserRelation();
		userRelation.setRelationType(1);
		userRelation.setExtendType(requestEntity.getExtendType());
		userRelation.setUserId(userId);
		userRelation.setRelId(requestEntity.getFamilyId());
		userRelation.setRelName(requestEntity.getFamilyName());
		userRelation.setUserName(userName);
		userRelationService.add(userRelation);
		
		UserInfo userInfo = new UserInfo();
		userInfo.setId(userId);
		userInfo.setNickname(requestUser.getNickname());
		userInfo.setRoleId(requestUser.getRoleId());
		response.setUserInfo(userInfo);
		return response;
	}	
	
	//更新家族管理员
	@RequestMapping("updateFamilyManagerInfo")
	public @ResponseBody ResponseEntity updateFamilyManagerInfo(@RequestBody FamilyManager requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("参数不能为空");
			return response;
		}
		//更新用户与家族的关系
		UserRelation userRelation = new UserRelation();
		userRelation.setId(requestEntity.getId());
		userRelation.setExtendType(requestEntity.getExtendType());
		userRelationService.update(userRelation);
		
		return response;
	}
	

	//删除家族管理员
	@RequestMapping("deleteFamilyManagerInfo")
	public @ResponseBody ResponseEntity deleteFamilyManagerInfo(@RequestBody FamilyManager requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("参数不能为空");
			return response;
		}
		//删除用户与家族的关系
		userRelationService.delete(requestEntity.getId());
		
		return response;
	}
	
	@RequestMapping("updateUserInfo")
	public @ResponseBody ResponseEntity updateUserInfo(@RequestBody UserInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("角色参数不能为空");
			return response;
		}
		//编辑用户的时候判断手机号是否重复
		UserInfo userInfoPhone = userInfoService.findByUserPhone(requestEntity.getPhone());
		if(null!=userInfoPhone&&userInfoPhone.getId()!=requestEntity.getId()){
			response.setSuccess(0);
			response.setErrorMsg("用户手机号重复");
			return response;
		}
		//编辑用户的时候判断用户名是否重复
		UserInfo userInfoAccount = userInfoService.findByUserName(requestEntity.getUsername());
		if(null!=userInfoAccount&&userInfoAccount.getId()!=requestEntity.getId()){
			response.setSuccess(0);
			response.setErrorMsg("用户账号重复");
			return response;
		}
		userInfoService.update(requestEntity);
		return response;
	}	
	
	@RequestMapping("deleteUserInfo")
	public @ResponseBody ResponseEntity deleteUserInfo(@RequestBody UserInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity.getId()==0){
			response.setSuccess(0);
			response.setErrorMsg("角色参数不能为空");
			return response;
		}
		userInfoService.delete(requestEntity.getId());
		return response;
	}

	@RequestMapping("userPasswordConfirm")
	public @ResponseBody ResponseEntity userPasswordConfirm(@RequestBody UserInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("角色参数不能为空");
			return response;
		}
		UserInfo user = userInfoService.get(requestEntity.getId());
		if(!user.getPassword().equals(MD5Utils.getPwd(requestEntity.getPassword()))){
			response.setSuccess(0);
			response.setErrorMsg("输入密码错误!");
			return response;
		}
		return response;
	}
	
	@RequestMapping("modifyPassword")
	public @ResponseBody ResponseEntity modifyPassword(@RequestBody UserInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("角色参数不能为空");
			return response;
		}
		String password = requestEntity.getPassword();
		requestEntity.setPassword(MD5Utils.getPwd(password));
		userInfoService.update(requestEntity);
		return response;
	}
	//根据用户id查询其权限列表
	@RequestMapping("findRoleAuthorityByUserId")
	public @ResponseBody RoleAuthorityVo findRoleAuthorityByUserId(@RequestBody UserInfo requestEntity){
		UserInfo userInfo = userInfoService.get(requestEntity.getId());
		RoleInfo roleInfo = roleInfoService.get(userInfo.getRoleId());
		RoleAuthorityVo roleAuthorityVo= roleAuthorityService.findRoleAuthorityByRoleId(userInfo.getRoleId());
		roleAuthorityVo.setRoleInfo(roleInfo);
		return roleAuthorityVo;
	}	
	
	@RequestMapping("findUserInfoListByNickname")
	public @ResponseBody ResponseUserInfoEntity findUserInfoListByNickname(@RequestBody UserInfo requestEntity){
		ResponseUserInfoEntity response= new ResponseUserInfoEntity();
		List<UserInfo> userInfoList = userInfoService.findUserInfoListByNickname(requestEntity.getNickname());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("userInfoList", userInfoList);
		response.setData(data);
		return response;
	}
	
}
