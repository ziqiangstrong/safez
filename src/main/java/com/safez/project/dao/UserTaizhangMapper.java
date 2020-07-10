package com.safez.project.dao;

import com.safez.project.entity.UserTaizhangWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTaizhangMapper {
    int insert(UserTaizhangWithBLOBs record);

    int insertSelective(UserTaizhangWithBLOBs record);
    List<UserTaizhangWithBLOBs>   getUserTaiZhangByUserName(String userName);
}