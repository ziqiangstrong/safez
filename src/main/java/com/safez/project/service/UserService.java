package com.safez.project.service;

import com.safez.project.dao.UserMapper;
import com.safez.project.entity.UserWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper ;


    public UserWithBLOBs getUser(String userName){
        return userMapper.getUser(userName);
    };
}
