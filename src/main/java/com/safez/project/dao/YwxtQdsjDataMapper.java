package com.safez.project.dao;

import com.safez.project.entity.YwxtQdsjDataWithBLOBs;

public interface YwxtQdsjDataMapper {
    int insert(YwxtQdsjDataWithBLOBs record);

    int insertSelective(YwxtQdsjDataWithBLOBs record);
}