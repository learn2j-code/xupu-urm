package com.bjp.pojo;

import java.util.Date;

public class RoleMenuRel {
    /** 菜单ID*/
    private Integer id;

    /** 角色id*/
    private Integer roleId;

    /** 菜单id*/
    private Integer menuId;

    /** 上级菜单id*/
    private Integer superMenuId;

    /** 菜单名*/
    private String menuName;

    /** 图标*/
    private String icon;

    /** 页面路由*/
    private String route;

    /** 当前菜单是否显示*/
    private Integer isShow;

    /** 是否有子菜单，0：没有子菜单，1：有*/
    private Integer haveChildrenMenu;

    /** 是否显示子菜单，0：不显示，1：显示*/
    private Integer isShowChildrenMenu;

    /** 活动状态，boolean，默认为false*/
    private Integer active;

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

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getSuperMenuId() {
        return superMenuId;
    }

    public void setSuperMenuId(Integer superMenuId) {
        this.superMenuId = superMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getHaveChildrenMenu() {
        return haveChildrenMenu;
    }

    public void setHaveChildrenMenu(Integer haveChildrenMenu) {
        this.haveChildrenMenu = haveChildrenMenu;
    }

    public Integer getIsShowChildrenMenu() {
        return isShowChildrenMenu;
    }

    public void setIsShowChildrenMenu(Integer isShowChildrenMenu) {
        this.isShowChildrenMenu = isShowChildrenMenu;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
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