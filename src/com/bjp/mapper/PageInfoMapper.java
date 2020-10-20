package com.bjp.mapper;

import com.bjp.pojo.PageInfo;
import com.bjp.pojo.PageInfoExample;
import java.util.List;

public interface PageInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PageInfo record);

    int insertSelective(PageInfo record);

    List<PageInfo> selectByExample(PageInfoExample example);

    PageInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PageInfo record);

    int updateByPrimaryKey(PageInfo record);
}