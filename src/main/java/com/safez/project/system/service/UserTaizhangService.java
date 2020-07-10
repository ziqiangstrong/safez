package com.safez.project.system.service;

import com.safez.project.dao.UserTaizhangMapper;
import com.safez.project.entity.UserTaizhangWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTaizhangService {

    @Autowired
    UserTaizhangMapper userTaizhangMapper;


    public List<UserTaizhangWithBLOBs> getUserTaiZhangByUserName(String userName) {
        return userTaizhangMapper.getUserTaiZhangByUserName(userName);
    }
}
