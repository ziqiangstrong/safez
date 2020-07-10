package com.safez.project.dao;

import com.safez.project.entity.YwxtJieruManagerWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YwxtJieruManagerMapper {
    int insert(YwxtJieruManagerWithBLOBs record);

    int insertSelective(YwxtJieruManagerWithBLOBs record);

    YwxtJieruManagerWithBLOBs getObjByTanzhen(String tanzhenId);
}