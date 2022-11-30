package com.blog.dao;

import com.blog.pojo.Btype;
import com.blog.pojo.BtypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BtypeMapper {
    long countByExample(BtypeExample example);

    int deleteByExample(BtypeExample example);

    int deleteByPrimaryKey(Integer typeid);

    int insert(Btype record);

    int insertSelective(Btype record);

    List<Btype> selectByExample(BtypeExample example);

    Btype selectByPrimaryKey(Integer typeid);

    int updateByExampleSelective(@Param("record") Btype record, @Param("example") BtypeExample example);

    int updateByExample(@Param("record") Btype record, @Param("example") BtypeExample example);

    int updateByPrimaryKeySelective(Btype record);

    int updateByPrimaryKey(Btype record);
}