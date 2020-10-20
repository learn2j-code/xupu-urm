package com.bjp.bam_authoritymanagement.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_authoritymanagement.service.RoleAuthorityService;
import com.bjp.bam_authoritymanagement.vo.authority.CFunctionInfo;
import com.bjp.bam_authoritymanagement.vo.authority.CModuleInfo;
import com.bjp.bam_authoritymanagement.vo.authority.CPageInfo;
import com.bjp.bam_authoritymanagement.vo.authority.CSystemInfo;
import com.bjp.bam_authoritymanagement.vo.authority.RoleAuthorityVo;
import com.bjp.mapper.RoleAuthorityMapper;
import com.bjp.pojo.FunctionInfo;
import com.bjp.pojo.ModuleInfo;
import com.bjp.pojo.PageInfo;
import com.bjp.pojo.RoleAuthority;
import com.bjp.pojo.RoleAuthorityExample;
import com.bjp.pojo.SystemInfo;

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {
	@Autowired
	RoleAuthorityMapper mapper;
	
	@Override
	public List<RoleAuthority> list() {
		RoleAuthorityExample example = new RoleAuthorityExample();
		example.setOrderByClause("id desc");
		return mapper.selectByExample(example);
	}

	@Override
	public void add(RoleAuthority record) {
		mapper.insertSelective(record);
	}

	@Override
	public void update(RoleAuthority record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public RoleAuthority get(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public RoleAuthorityVo findRoleAuthorityByRoleId(Integer roleId) {
		RoleAuthorityExample example = new RoleAuthorityExample();
		example.setOrderByClause("system_id asc,module_id asc,page_id asc,function_id asc");
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<RoleAuthority> roleAuthorityList = mapper.selectByExample(example);
		return packRoleAuthorityListToRoleAuthorityVo(roleAuthorityList);
	}
	
	private RoleAuthorityVo packRoleAuthorityListToRoleAuthorityVo(List<RoleAuthority> roleAuthorityList){
		RoleAuthorityVo roleAuthorityVo = new RoleAuthorityVo();
		HashMap<Integer, CSystemInfo> systemInfoMap = new HashMap<Integer, CSystemInfo>();
		for(RoleAuthority roleAuthority:roleAuthorityList){
			Integer roleAuthorityId = roleAuthority.getId();
			Integer systemId = roleAuthority.getSystemId();
			String systemName = roleAuthority.getSystemName();
			String systemAddress = roleAuthority.getSystemAddress();
			
			Integer moduleId = roleAuthority.getModuleId();
			String moduleName = roleAuthority.getModuleName();
			
			Integer pageId = roleAuthority.getPageId();
			String pageName = roleAuthority.getPageName();
			
			Integer functionId = roleAuthority.getFunctionId();
			String functionName = roleAuthority.getFunctionName();
			String functionAddress = roleAuthority.getFunctionAddress();
			Integer bannedFlag =roleAuthority.getBannedFlag();
			Boolean checked = false;
			if(bannedFlag==0){
				checked = true;
			}
			
			if(systemInfoMap.containsKey(systemId)){
				CSystemInfo csystemInfo = systemInfoMap.get(systemId);
				HashMap<Integer, CModuleInfo> moduleInfoMap = csystemInfo.getChildrenMap();
				if(moduleInfoMap.containsKey(moduleId)){
					CModuleInfo cmoduleInfo = moduleInfoMap.get(moduleId);
					HashMap<Integer, CPageInfo> pageInfoMap = cmoduleInfo.getChildrenMap();
					if(pageInfoMap.containsKey(pageId)){
						CPageInfo cpageInfo = pageInfoMap.get(pageId);
						HashMap<Integer, CFunctionInfo> functionInfoMap = cpageInfo.getChildrenMap();
						if(functionInfoMap.containsKey(functionId)){
							continue;
						}else{
							CFunctionInfo functionInfo = new CFunctionInfo();
							functionInfo.setId(functionId);
							functionInfo.setFunctionName(functionName);
							functionInfo.setFunctionAddress(functionAddress);
							functionInfo.setPageId(pageId);
							functionInfo.setChecked(checked);
							functionInfo.setRoleAuthorityId(roleAuthorityId);
							functionInfoMap.put(functionId, functionInfo);
						}
					}else{
						HashMap<Integer,CFunctionInfo> functionInfoMap = new HashMap<Integer, CFunctionInfo>();
						CFunctionInfo functionInfo = new CFunctionInfo();
						functionInfo.setId(functionId);
						functionInfo.setFunctionName(functionName);
						functionInfo.setFunctionAddress(functionAddress);
						functionInfo.setPageId(pageId);
						functionInfo.setChecked(checked);
						functionInfo.setRoleAuthorityId(roleAuthorityId);
						functionInfoMap.put(functionId, functionInfo);
						
						CPageInfo cpageInfo = new CPageInfo();
						PageInfo pageInfo = new PageInfo();
						pageInfo.setId(pageId);
						pageInfo.setPageName(pageName);
						pageInfo.setModuleId(moduleId);
						cpageInfo.setPageInfo(pageInfo);
						cpageInfo.setChildrenMap(functionInfoMap);
						pageInfoMap.put(pageId, cpageInfo);
					}
				}else{
					HashMap<Integer,CFunctionInfo> functionInfoMap = new HashMap<Integer, CFunctionInfo>();
					CFunctionInfo functionInfo = new CFunctionInfo();
					functionInfo.setId(functionId);
					functionInfo.setFunctionName(functionName);
					functionInfo.setFunctionAddress(functionAddress);
					functionInfo.setPageId(pageId);
					functionInfo.setChecked(checked);
					functionInfo.setRoleAuthorityId(roleAuthorityId);
					functionInfoMap.put(functionId, functionInfo);
					
					HashMap<Integer, CPageInfo> pageInfoMap = new HashMap<Integer, CPageInfo>();
					CPageInfo cpageInfo = new CPageInfo();
					PageInfo pageInfo = new PageInfo();
					pageInfo.setId(pageId);
					pageInfo.setPageName(pageName);
					pageInfo.setModuleId(moduleId);
					cpageInfo.setPageInfo(pageInfo);
					cpageInfo.setChildrenMap(functionInfoMap);
					pageInfoMap.put(pageId, cpageInfo);
					
					CModuleInfo cmoduleInfo = new CModuleInfo();
					ModuleInfo moduleInfo = new ModuleInfo();
					moduleInfo.setId(moduleId);
					moduleInfo.setModuleName(moduleName);
					moduleInfo.setSystemId(systemId);
					cmoduleInfo.setModuleInfo(moduleInfo);
					cmoduleInfo.setChildrenMap(pageInfoMap);
					moduleInfoMap.put(moduleId, cmoduleInfo);
					
				}
			}else{
				HashMap<Integer,CFunctionInfo> functionInfoMap = new HashMap<Integer, CFunctionInfo>();
				CFunctionInfo functionInfo = new CFunctionInfo();
				functionInfo.setId(functionId);
				functionInfo.setFunctionName(functionName);
				functionInfo.setFunctionAddress(functionAddress);
				functionInfo.setPageId(pageId);
				functionInfo.setChecked(checked);
				functionInfo.setRoleAuthorityId(roleAuthorityId);
				functionInfoMap.put(functionId, functionInfo);
				
				
				HashMap<Integer, CPageInfo> pageInfoMap = new HashMap<Integer, CPageInfo>();
				CPageInfo cpageInfo = new CPageInfo();
				PageInfo pageInfo = new PageInfo();
				pageInfo.setId(pageId);
				pageInfo.setPageName(pageName);
				pageInfo.setModuleId(moduleId);
				cpageInfo.setPageInfo(pageInfo);
				cpageInfo.setChildrenMap(functionInfoMap);
				pageInfoMap.put(pageId, cpageInfo);
				
				HashMap<Integer, CModuleInfo> moduleInfoMap = new HashMap<Integer, CModuleInfo>();
				CModuleInfo cmoduleInfo = new CModuleInfo();
				ModuleInfo moduleInfo = new ModuleInfo();
				moduleInfo.setId(moduleId);
				moduleInfo.setModuleName(moduleName);
				moduleInfo.setSystemId(systemId);
				cmoduleInfo.setModuleInfo(moduleInfo);
				cmoduleInfo.setChildrenMap(pageInfoMap);
				moduleInfoMap.put(moduleId, cmoduleInfo);
				
				CSystemInfo csystemInfo = new CSystemInfo();
				SystemInfo systemInfo = new SystemInfo();
				systemInfo.setId(systemId);
				systemInfo.setSystemName(systemName);
				systemInfo.setSystemAddress(systemAddress);
				csystemInfo.setSystemInfo(systemInfo);
				csystemInfo.setChildrenMap(moduleInfoMap);
				systemInfoMap.put(systemId, csystemInfo);
			}
		}
		roleAuthorityVo.setSystemInfoMap(systemInfoMap);
		return roleAuthorityVo;
	}

	@Override
	public List<RoleAuthority> findRoleAuthorityListByRoleId(Integer roleId) {
		RoleAuthorityExample example = new RoleAuthorityExample();
		example.setOrderByClause("system_id asc,module_id asc,page_id asc,function_id asc");
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.selectByExample(example);
	}

	@Override
	public List<RoleAuthority> findRoleAuthorityListBySystemId(Integer systemId) {
		RoleAuthorityExample example = new RoleAuthorityExample();
		example.createCriteria().andSystemIdEqualTo(systemId);
		return mapper.selectByExample(example);
	}

	@Override
	public List<RoleAuthority> findRoleAuthorityListByModuleId(Integer moduleId) {
		RoleAuthorityExample example = new RoleAuthorityExample();
		example.createCriteria().andModuleIdEqualTo(moduleId);
		return mapper.selectByExample(example);
	}

	@Override
	public List<RoleAuthority> findRoleAuthorityListByPageId(Integer pageId) {
		RoleAuthorityExample example = new RoleAuthorityExample();
		example.createCriteria().andPageIdEqualTo(pageId);
		return mapper.selectByExample(example);
	}

	@Override
	public List<RoleAuthority> findRoleAuthorityListByFunctionId(Integer functionId) {
		RoleAuthorityExample example = new RoleAuthorityExample();
		example.createCriteria().andFunctionIdEqualTo(functionId);
		return mapper.selectByExample(example);
	}

	
}
