package com.safez.project.system.service;

import com.safez.project.dao.YwxtKeyManagerMapper;
import com.safez.project.entity.YwxtKeyManagerWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YwxtKeyManagerService {

    @Autowired
    YwxtKeyManagerMapper ywxtKeyManagerMapper;


    public YwxtKeyManagerWithBLOBs getYwxtkeyManagerByYwId(String ywid){
        return ywxtKeyManagerMapper.getYwxtkeyManagerByYwId(ywid);

    }


}
