package com.safez.project.dao;

import com.safez.project.entity.YwtanzhenUseWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YwtanzhenUseMapper {
    int insert(YwtanzhenUseWithBLOBs record);

    int insertSelective(YwtanzhenUseWithBLOBs record);

    YwtanzhenUseWithBLOBs  getObjById(String transYwid);
}