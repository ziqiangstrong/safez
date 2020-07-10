package com.safez.project.dao;

import com.github.pagehelper.Page;
import com.safez.project.entity.TanzhenIpWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TanzhenIpMapper {

    TanzhenIpWithBLOBs getById(Integer id);

    int insert(TanzhenIpWithBLOBs record);

    int insertSelective(TanzhenIpWithBLOBs record);

    Page<TanzhenIpWithBLOBs> getPageList();
}