package com.safez.project.dao;

import com.safez.project.entity.UserBehaviorWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserBehaviorMapper {
    int insert(UserBehaviorWithBLOBs record);

    int insertSelective(UserBehaviorWithBLOBs record);

    List<UserBehaviorWithBLOBs> getEntityByIp(String ip);
}