package com.safez.project.dao;

import com.github.pagehelper.Page;
import com.safez.project.entity.YwxtGjdataWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface YwxtGjdataMapper {
    int insert(YwxtGjdataWithBLOBs record);

    int insertSelective(YwxtGjdataWithBLOBs record);


    Page<YwxtGjdataWithBLOBs> getPageList();


    int updateState(String [] ids);


    YwxtGjdataWithBLOBs getObjById(String id);


    YwxtGjdataWithBLOBs getObjByIp(String ip);

    List<Map> getYwtzByYwId(String ywId);
}