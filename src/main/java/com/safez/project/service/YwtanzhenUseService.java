package com.safez.project.service;

import com.safez.project.dao.YwtanzhenUseMapper;
import com.safez.project.entity.YwtanzhenUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YwtanzhenUseService {

    @Autowired
    YwtanzhenUseMapper ywtanzhenUseMapper;

    public YwtanzhenUse getObjById(String transYwid){
        return ywtanzhenUseMapper.getObjById(transYwid);
    }

}
