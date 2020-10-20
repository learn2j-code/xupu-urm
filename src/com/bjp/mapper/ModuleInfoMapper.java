package com.bjp.mapper;

import com.bjp.pojo.ModuleInfo;
import com.bjp.pojo.ModuleInfoExample;
import java.util.List;

public interface ModuleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModuleInfo record);

    int insertSelective(ModuleInfo record);

    List<ModuleInfo> selectByExample(ModuleInfoExample example);

    ModuleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModuleInfo record);

    int updateByPrimaryKey(ModuleInfo record);
}