package com.bjp.mapper;

import com.bjp.pojo.RoleMenuRel;
import com.bjp.pojo.RoleMenuRelExample;
import java.util.List;

public interface RoleMenuRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenuRel record);

    int insertSelective(RoleMenuRel record);

    List<RoleMenuRel> selectByExample(RoleMenuRelExample example);

    RoleMenuRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenuRel record);

    int updateByPrimaryKey(RoleMenuRel record);
}