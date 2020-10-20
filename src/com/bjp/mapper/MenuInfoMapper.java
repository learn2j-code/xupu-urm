package com.bjp.mapper;

import com.bjp.pojo.MenuInfo;
import com.bjp.pojo.MenuInfoExample;
import java.util.List;

public interface MenuInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    List<MenuInfo> selectByExample(MenuInfoExample example);

    MenuInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);
}