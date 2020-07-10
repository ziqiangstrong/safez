package com.safez.project.dao;

import com.safez.project.entity.UserWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);


    UserWithBLOBs getUser(String username);
}