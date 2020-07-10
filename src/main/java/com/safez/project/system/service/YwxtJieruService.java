package com.safez.project.system.service;

import com.safez.project.dao.YwxtJieruManagerMapper;
import com.safez.project.entity.YwxtJieruManagerWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YwxtJieruService {


    @Autowired
    YwxtJieruManagerMapper ywxtJieruManagerMapper;



    public YwxtJieruManagerWithBLOBs getObjByTanzhen(String tanzhenId){
        return ywxtJieruManagerMapper.getObjByTanzhen(tanzhenId);
    }


}
