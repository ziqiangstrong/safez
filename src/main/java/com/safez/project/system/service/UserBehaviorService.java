package com.safez.project.system.service;

import com.safez.project.dao.UserBehaviorMapper;
import com.safez.project.entity.UserBehaviorWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBehaviorService {

    @Autowired
    UserBehaviorMapper userBehaviorMapper;

    public List<UserBehaviorWithBLOBs> getEntityByIp(String ip){
        return userBehaviorMapper.getEntityByIp(ip);
    }

}
