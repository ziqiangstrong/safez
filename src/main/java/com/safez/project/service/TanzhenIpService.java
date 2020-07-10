package com.safez.project.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.safez.project.dao.TanzhenIpMapper;
import com.safez.project.entity.TanzhenIpWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TanzhenIpService {

    @Autowired
    private TanzhenIpMapper tanzhenIpMapper ;

    public TanzhenIpWithBLOBs getById(Integer id){
        return tanzhenIpMapper.getById(id);
    }
    public PageInfo<TanzhenIpWithBLOBs> getPageList(Integer pageNum, Integer pageSize){
        if(pageNum==null){
            pageNum=1;
        } if(pageSize==null){
            pageSize=15;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<TanzhenIpWithBLOBs> list=tanzhenIpMapper.getPageList();
        PageInfo<TanzhenIpWithBLOBs> pageList= new PageInfo<>(list);
        return pageList;
    }
}
