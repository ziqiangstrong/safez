package com.safez.project.dao;

import com.safez.project.entity.YwxtKeyManagerWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YwxtKeyManagerMapper {
    int insert(YwxtKeyManagerWithBLOBs record);

    int insertSelective(YwxtKeyManagerWithBLOBs record);

    YwxtKeyManagerWithBLOBs getYwxtkeyManagerByYwId(String ywid);
}