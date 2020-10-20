package com.bjp.bam_authoritymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjp.bam_authoritymanagement.service.AuthorityCommonService;
import com.bjp.bam_authoritymanagement.service.FunctionInfoService;
import com.bjp.bam_authoritymanagement.service.ModuleInfoService;
import com.bjp.bam_authoritymanagement.service.PageInfoService;
import com.bjp.bam_authoritymanagement.service.RoleAuthorityService;
import com.bjp.bam_authoritymanagement.service.RoleInfoService;
import com.bjp.bam_authoritymanagement.service.SystemInfoService;
import com.bjp.bam_authoritymanagement.vo.FunctionInfoVo;
import com.bjp.bam_authoritymanagement.vo.ModuleInfoVo;
import com.bjp.bam_authoritymanagement.vo.PageInfoVo;
import com.bjp.bam_authoritymanagement.vo.RoleInfoVo;
import com.bjp.bam_authoritymanagement.vo.SystemInfoVo;
import com.bjp.bam_authoritymanagement.vo.authority.RoleAuthorityVo;
import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.pojo.FunctionInfo;
import com.bjp.pojo.ModuleInfo;
import com.bjp.pojo.RoleAuthority;
import com.bjp.pojo.RoleInfo;
import com.bjp.pojo.SystemInfo;
import com.bjp.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("")
public class AuthorityController {
	@Autowired
	FunctionInfoService functionInfoService;
	
	@Autowired
	ModuleInfoService moduleInfoService;
	
	@Autowired
	PageInfoService pageInfoService;
	
	@Autowired
	RoleAuthorityService roleAuthorityService;
	
	@Autowired
	SystemInfoService systemInfoService;
	
	@Autowired
	RoleInfoService roleInfoService;
	
	@Autowired
	AuthorityCommonService authorityCommonService;
	@RequestMapping("role")
	public ModelAndView listCategory(){
		ModelAndView mav = new ModelAndView("role");
		return mav;
	}
	
	@RequestMapping("findAllSystemInfo")
    public @ResponseBody SystemInfoVo findAllSystemInfo(@RequestBody SystemInfoVo requestEntity){
    	//分页参数设置
    	Page page = requestEntity.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	
    	List<SystemInfo> systemInfoList = systemInfoService.list();
		int total = (int)new PageInfo<>(systemInfoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		requestEntity.setSystemInfoList(systemInfoList);
		requestEntity.setPage(page);
        return requestEntity;
    }
	
	@RequestMapping("findSystemInfoById")
    public @ResponseBody SystemInfo findSystemInfoById(@RequestBody SystemInfo requestEntity){
        return systemInfoService.get(requestEntity.getId());
    }
	
	@RequestMapping("addSystemInfo")
	public @ResponseBody ResponseEntity addSystemInfo(@RequestBody SystemInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("系统参数不能为空");
			return response;
		}
		systemInfoService.add(requestEntity);
		
		return response;
	}	
	@RequestMapping("updateSystemInfo")
	public @ResponseBody ResponseEntity updateSystemInfo(@RequestBody SystemInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("系统参数不能为空");
			return response;
		}
		authorityCommonService.updateRoleAuthorityWhenUpdateSystemInfo(requestEntity);
		return response;
	}	
	@RequestMapping("deleteSystemInfo")
	public @ResponseBody ResponseEntity deleteSystemInfo(@RequestBody SystemInfo requestEntity){
		ResponseEntity response = new ResponseEntity();
		if(requestEntity!=null&&requestEntity.getId()!=0){
			List<ModuleInfo> moduleInfoList = moduleInfoService.findAllModuleInfoBySystem(requestEntity.getId());
			if(moduleInfoList.size()>0){
				response.setSuccess(0);
				response.setErrorMsg("该系统下还存在模块，需要先删除子模块");
				return response;
			}
			systemInfoService.delete(requestEntity.getId());
			return response;
		}
		response.setSuccess(0);
		response.setErrorMsg("id为空");
		return response;
	}
	
	@RequestMapping("findAllModuleInfoBySystem")
    public @ResponseBody ModuleInfoVo findAllModuleInfoBySystem(@RequestBody ModuleInfoVo responseEntity){
    	//分页参数设置
    	Page page = responseEntity.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	
    	List<ModuleInfo> moduleInfoList = moduleInfoService.findAllModuleInfoBySystem(responseEntity.getSystemId());
		int total = (int)new PageInfo<>(moduleInfoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		responseEntity.setModuleInfoList(moduleInfoList);
		responseEntity.setPage(page);
        return responseEntity;
    }
	
	@RequestMapping("findModuleInfoById")
    public @ResponseBody ModuleInfo findModuleInfoById(@RequestBody ModuleInfo requestEntity){
        return moduleInfoService.get(requestEntity.getId());
    }
	
	@RequestMapping("addModuleInfo")
	public @ResponseBody ResponseEntity addModuleInfo(@RequestBody ModuleInfo responseEntity){
		ResponseEntity response= new ResponseEntity();
		if(responseEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("模块参数不能为空");
			return response;
		}
		moduleInfoService.add(responseEntity);
		
		return response;
	}	
	@RequestMapping("updateModuleInfo")
	public @ResponseBody ResponseEntity updateModuleInfo(@RequestBody ModuleInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("模块参数不能为空");
			return response;
		}
		authorityCommonService.updateRoleAuthorityWhenUpdateModuleInfo(requestEntity);
		return response;
	}	
	@RequestMapping("deleteModuleInfo")
	public @ResponseBody ResponseEntity deleteModuleInfo(@RequestBody ModuleInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity!=null&&requestEntity.getId()!=0){
			List<com.bjp.pojo.PageInfo> pageInfoList = pageInfoService.findAllPageInfoByModule(requestEntity.getId());
			if(pageInfoList.size()>0){
				response.setSuccess(0);
				response.setErrorMsg("该模块下还存在页面，需要先删除子页面");
				return response;
			}
			moduleInfoService.delete(requestEntity.getId());
			return response;
		}
		response.setSuccess(0);
		response.setErrorMsg("id为空");
		return response;
	}	
	
	@RequestMapping("findAllPageInfoByModule")
    public @ResponseBody PageInfoVo findAllPageInfoByModule(@RequestBody PageInfoVo requestEntity){
    	//分页参数设置
    	Page page = requestEntity.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	
    	List<com.bjp.pojo.PageInfo> pageInfoList = pageInfoService.findAllPageInfoByModule(requestEntity.getModuleId());
		int total = (int)new PageInfo<>(pageInfoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		requestEntity.setPageInfoList(pageInfoList);
		requestEntity.setPage(page);
        return requestEntity;
    }
	
	@RequestMapping("findPageInfoById")
    public @ResponseBody com.bjp.pojo.PageInfo findPageInfoById(@RequestBody com.bjp.pojo.PageInfo requestEntity){
        return pageInfoService.get(requestEntity.getId());
    }
	
	@RequestMapping("addPageInfo")
	public @ResponseBody ResponseEntity addPageInfo(@RequestBody com.bjp.pojo.PageInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("页面参数不能为空");
			return response;
		}
		pageInfoService.add(requestEntity);
		
		return response;
	}	
	@RequestMapping("updatePageInfo")
	public @ResponseBody ResponseEntity updatePageInfo(@RequestBody com.bjp.pojo.PageInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("页面参数不能为空");
			return response;
		}
		authorityCommonService.updateRoleAuthorityWhenUpdatePageInfo(requestEntity);
		return response;
	}	
	
	@RequestMapping("deletePageInfo")
	public @ResponseBody ResponseEntity deletePageInfo(@RequestBody com.bjp.pojo.PageInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity!=null&&requestEntity.getId()!=0){
			List<FunctionInfo> functionInfoList = functionInfoService.findAllFunctionInfoByPageInfo(requestEntity.getId());
			if(functionInfoList.size()>0){
				response.setSuccess(0);
				response.setErrorMsg("该模块下还存在功能，需要先删除子子功能");
				return response;
			}
			pageInfoService.delete(requestEntity.getId());
			return response;
		}
		response.setSuccess(0);
		response.setErrorMsg("id为空");
		return response;
	}
	
	@RequestMapping("findAllFunctionInfoByPageInfo")
    public @ResponseBody FunctionInfoVo findAllFunctionInfoByPageInfo(@RequestBody FunctionInfoVo requestEntity){
    	//分页参数设置
    	Page page = requestEntity.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	
    	List<FunctionInfo> functionInfoList = functionInfoService.findAllFunctionInfoByPageInfo(requestEntity.getPageId());
		int total = (int)new PageInfo<>(functionInfoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		requestEntity.setFunctionInfoList(functionInfoList);
		requestEntity.setPage(page);
        return requestEntity;
    }
	
	@RequestMapping("findFunctionInfoById")
    public @ResponseBody FunctionInfo findFunctionInfoById(@RequestBody FunctionInfo requestEntity){
        return functionInfoService.get(requestEntity.getId());
    }
	
	@RequestMapping("addFunctionInfo")
	public @ResponseBody ResponseEntity addFunctionInfo(@RequestBody FunctionInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("功能参数不能为空");
			return response;
		}
		//添加功能时，为角色权限里所有角色都添加该功能
		try{
			authorityCommonService.addRoleAuthorityWhenAddFunction(requestEntity);
		}catch(Exception e){
			response.setSuccess(0);
			response.setErrorMsg("添加功能失败");
		}
		return response;
	}	
	@RequestMapping("updateFunctionInfo")
	public @ResponseBody ResponseEntity updateFunctionInfo(@RequestBody FunctionInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("功能参数不能为空");
			return response;
		}
		authorityCommonService.updateRoleAuthorityWhenUpdateFunctionInfo(requestEntity);
		return response;
	}	
	@RequestMapping("deleteFunctionInfo")
	public @ResponseBody ResponseEntity deleteFunctionInfo(@RequestBody FunctionInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity!=null&&requestEntity.getId()!=0){
			authorityCommonService.deleteRoleAuthorityWhenDeleteFunctionInfo(requestEntity.getId());
			return response;
		}
		response.setSuccess(0);
		response.setErrorMsg("id为空");
		return response;
	}
	
	@RequestMapping("findAllRoleInfo")
    public @ResponseBody RoleInfoVo findAllRoleInfo(@RequestBody RoleInfoVo requestEntity){
    	//分页参数设置
    	Page page = requestEntity.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	
    	List<RoleInfo> roleInfoList = roleInfoService.list();
		int total = (int)new PageInfo<>(roleInfoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		requestEntity.setRoleInfoList(roleInfoList);
		requestEntity.setPage(page);
        return requestEntity;
    }
	
	@RequestMapping("findRoleInfoById")
    public @ResponseBody RoleInfo findRoleInfoById(@RequestBody RoleInfo requestEntity){
        return roleInfoService.get(requestEntity.getId());
    }
	
	@RequestMapping("addRoleInfo")
	public @ResponseBody ResponseEntity addRoleInfo(@RequestBody RoleInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("角色参数不能为空");
			return response;
		}
		
		//添加角色的时候，查询所有的功能，并把所有的功能都加到该角色之上，不过都为禁止的功能
		try{
			authorityCommonService.addRoleAuthorityWhenAddRoleInfo(requestEntity);
		}catch(Exception e){
			response.setSuccess(0);
			response.setErrorMsg("添加角色失败");
		}
		
		return response;
	}	
		
	@RequestMapping("updateRoleInfo")
	public @ResponseBody ResponseEntity updateRoleInfo(@RequestBody RoleInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("角色参数不能为空");
			return response;
		}
		roleInfoService.update(requestEntity);
		return response;
	}	
	
	@RequestMapping("deleteRoleInfo")
	public @ResponseBody ResponseEntity deleteRoleInfo(@RequestBody RoleInfo requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity.getId()==0){
			response.setSuccess(0);
			response.setErrorMsg("角色参数不能为空");
			return response;
		}
		authorityCommonService.deleteRoleAuthorityWhenDeleteRoleInfo(requestEntity.getId());
		return response;
	}
	
	//根据角色查询角色权限
	@RequestMapping("findRoleAuthorityByRoleId")
	public @ResponseBody RoleAuthorityVo findRoleAuthorityByRoleId(@RequestBody RoleAuthority requestEntity){
		RoleAuthorityVo roleAuthorityVo= roleAuthorityService.findRoleAuthorityByRoleId(requestEntity.getRoleId());
		RoleInfo roleInfo = roleInfoService.get(requestEntity.getRoleId());
		roleAuthorityVo.setRoleInfo(roleInfo);
		return roleAuthorityVo;
	}	
	
	@RequestMapping("updateRoleAuthority")
	public @ResponseBody ResponseEntity updateRoleAuthority(@RequestBody RoleAuthority requestEntity){
		ResponseEntity response= new ResponseEntity();
		if(requestEntity==null){
			response.setSuccess(0);
			response.setErrorMsg("角色权限参数不能为空");
			return response;
		}
		roleAuthorityService.update(requestEntity);
		return response;
	}	
	
	//查询测试
	@RequestMapping("findTest")
	public @ResponseBody List<SystemInfo> findTest(){
		List<SystemInfo> systemList= systemInfoService.list();
		return systemList;
	}
}
