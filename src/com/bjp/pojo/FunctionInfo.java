package com.bjp.pojo;

import java.util.Date;

public class FunctionInfo {
    /** 功能id*/
    private Integer id;

    /** 功能名称*/
    private String functionName;

    /** 功能访问地址*/
    private String functionAddress;

    /** 页面id*/
    private Integer pageId;

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