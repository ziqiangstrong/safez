package com.safez.project.dao;

import com.safez.project.entity.YwxtHdSjWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface YwxtHdSjMapper {
    int insert(YwxtHdSjWithBLOBs record);

    int insertSelective(YwxtHdSjWithBLOBs record);

    List<Map> getUserBehavior(Map param);
}