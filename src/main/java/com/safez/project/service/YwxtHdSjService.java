package com.safez.project.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.safez.project.dao.YwxtHdSjMapper;
import com.safez.project.entity.TanzhenIpWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class YwxtHdSjService {
    @Autowired
    YwxtHdSjMapper ywxtHdSjMapper;


    public PageInfo<Map> getUserBehavior(Integer pageNum, Integer pageSize,Map param){
        if(pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=15;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = ywxtHdSjMapper.getUserBehavior(param);
        PageInfo<Map> pageList= new PageInfo<>(list);
        return  pageList;
    }

}
