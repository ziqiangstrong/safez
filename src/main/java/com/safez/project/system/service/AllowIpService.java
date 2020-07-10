package com.safez.project.system.service;

import com.safez.project.dao.AllowIpMapper;
import com.safez.project.entity.AllowIpWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllowIpService {

    @Autowired
    AllowIpMapper allowIpMapper;

    public List<AllowIpWithBLOBs> getList(String ip){
        return allowIpMapper.getList(ip);
    }
}
