package com.bjp.mapper;

import com.bjp.pojo.UserRelation;
import com.bjp.pojo.UserRelationExample;
import java.util.List;

public interface UserRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRelation record);

    int insertSelective(UserRelation record);

    List<UserRelation> selectByExample(UserRelationExample example);

    UserRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRelation record);

    int updateByPrimaryKey(UserRelation record);
}