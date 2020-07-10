package com.safez.project.dao;

import com.safez.project.entity.TanzhengManagerWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TanzhengManagerMapper {
    int insert(TanzhengManagerWithBLOBs record);

    int insertSelective(TanzhengManagerWithBLOBs record);


    TanzhengManagerWithBLOBs getObjByYwid();

    List<Map> getTanzhenAll();
}