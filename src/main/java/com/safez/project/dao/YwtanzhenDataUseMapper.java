package com.safez.project.dao;

import com.safez.project.entity.YwtanzhenDataUse;
import com.safez.project.entity.YwtanzhenDataUseWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YwtanzhenDataUseMapper {
    int insert(YwtanzhenDataUseWithBLOBs record);

    int insertSelective(YwtanzhenDataUseWithBLOBs record);

    YwtanzhenDataUse getYwtanzhenDataUse(String ywid,String tzid);

    List<YwtanzhenDataUse> getYwtanzhenDataUseList(String ywid);
}