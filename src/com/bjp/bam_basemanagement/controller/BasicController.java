package com.bjp.bam_basemanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.constant.CommonConstant;

//告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class BasicController {
	
	@RequestMapping("/")
	public ModelAndView  indexCore(){
	    ModelAndView mv = new ModelAndView("/index");
	    return mv;  
	}
	
	@RequestMapping("")
	public ModelAndView welcome2(){
		ModelAndView mav = new ModelAndView("navigatebar");
		return mav;
	}
	
	
	/**
	 * 添加客户信息
	 * @param clientInfo
	 * @return
	 */
//	@RequestMapping("addClientInfo")
//	public @ResponseBody ResponseEntity addClientInfo(@RequestBody ClientInfo clientInfo){
//		ResponseEntity responseEntity = new ResponseEntity();
//		try {
//			clientInfoService.add(clientInfo);
//		} catch (Exception e) {
//			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
//			responseEntity.setErrorMsg(e.getMessage());
//		}
//        return responseEntity;
//	}
	
}
