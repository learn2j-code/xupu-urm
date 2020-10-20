package com.bjp.mapper;

import com.bjp.pojo.FunctionInfo;
import com.bjp.pojo.FunctionInfoExample;
import java.util.List;

public interface FunctionInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FunctionInfo record);

    int insertSelective(FunctionInfo record);

    List<FunctionInfo> selectByExample(FunctionInfoExample example);

    FunctionInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FunctionInfo record);

    int updateByPrimaryKey(FunctionInfo record);
}