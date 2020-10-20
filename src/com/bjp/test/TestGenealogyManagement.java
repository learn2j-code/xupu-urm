package com.bjp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjp.bam_authoritymanagement.service.RoleAuthorityService;
import com.bjp.bam_authoritymanagement.vo.authority.RoleAuthorityVo;
import com.bjp.bam_usermanagement.service.UserInfoService;
import com.bjp.constant.HouseholdConstant;
import com.bjp.pojo.UserInfo;
import com.bjp.util.Page;
import com.bjp.util.jpinyin.PinyinException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestGenealogyManagement {
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	RoleAuthorityService roleAuthorityService;
//	@Test
	public void findByPage() {
		Page page = new Page();
		int count = 6;
		int num = 1;
		page.setStart(count*(num-1));
		page.setCount(count);
		PageHelper.offsetPage(page.getStart(),page.getCount());
		List<UserInfo> userList = userInfoService.list();
		int total = (int) new PageInfo<>(userList).getTotal();
        page.setTotal(total);
		for(UserInfo user:userList){
//			System.out.println("ID："+navigateBar.getNbId());
//			System.out.println("Comments："+navigateBar.getComments());
//			System.out.println("Name："+navigateBar.getNavName());
//			System.out.println("Location："+navigateBar.getNavBitmapLocation());
		}
	}
	@Test
	public void findRoleAuthorityByRoleId(){
		RoleAuthorityVo roleAuthorityVo = roleAuthorityService.findRoleAuthorityByRoleId(1);
		roleAuthorityVo.getSystemInfoMap();
	}
	
}
