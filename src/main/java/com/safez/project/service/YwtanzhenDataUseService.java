package com.safez.project.service;

import com.safez.project.dao.YwtanzhenDataUseMapper;
import com.safez.project.entity.YwtanzhenDataUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YwtanzhenDataUseService {


    @Autowired
    YwtanzhenDataUseMapper ywtanzhenDataUseMapper;


    public YwtanzhenDataUse getYwtanzhenDataUse(String ywid,String tzid){
        return ywtanzhenDataUseMapper.getYwtanzhenDataUse(ywid,tzid);
    }


    public List<YwtanzhenDataUse> getYwtanzhenDataUseList(String ywid){
        return ywtanzhenDataUseMapper.getYwtanzhenDataUseList(ywid);
    }

}
