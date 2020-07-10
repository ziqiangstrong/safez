package com.safez.project.dao;

import com.safez.project.entity.AllowIpWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AllowIpMapper {
    int insert(AllowIpWithBLOBs record);

    int insertSelective(AllowIpWithBLOBs record);

    List<AllowIpWithBLOBs> getList(String ip);
}