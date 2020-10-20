package com.bjp.pojo;

import java.util.Date;

public class RoleAuthority {
    /** 角色权限id*/
    private Integer id;

    /** 角色id*/
    private Integer roleId;

    /** 功能id*/
    private Integer functionId;

    /** 功能名称*/
    private String functionName;

    /** 功能访问地址*/
    private String functionAddress;

    /** 页面id*/
    private Integer pageId;

    /** 页面名称*/
    private String pageName;

    /** 模块id*/
    private Integer moduleId;

    /** 模块名称*/
    private String moduleName;

    /** 系统id*/
    private Integer systemId;

    /** 系统名称*/
    private String systemName;

    /** 系统地址*/
    private String systemAddress;

    /** 权限禁用标识，0：默认不禁用，1：禁用*/
    private Integer bannedFlag;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getFunctionAddress() {
        return functionAddress;
    }

    public void setFunctionAddress(String functionAddress) {
        this.functionAddress = functionAddress == null ? null : functionAddress.trim();
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName == null ? null : pageName.trim();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getSystemAddress() {
        return systemAddress;
    }

    public void setSystemAddress(String systemAddress) {
        this.systemAddress = systemAddress == null ? null : systemAddress.trim();
    }

    public Integer getBannedFlag() {
        return bannedFlag;
    }

    public void setBannedFlag(Integer bannedFlag) {
        this.bannedFlag = bannedFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}