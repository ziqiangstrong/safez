package com.safez.project.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.safez.project.dao.YwxtGjdataMapper;
import com.safez.project.entity.UserWithBLOBs;
import com.safez.project.entity.YwxtGjdataWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class YwxtGjDataService {



    @Autowired
    YwxtGjdataMapper ywxtGjdataMapper;

    public  int insert(YwxtGjdataWithBLOBs ywxtGjdataWithBLOBs){
        return  ywxtGjdataMapper.insert(ywxtGjdataWithBLOBs);
    }

    public PageInfo<YwxtGjdataWithBLOBs> getPageList(Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum=1;
        } if(pageSize==null){
            pageSize=15;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<YwxtGjdataWithBLOBs> list= ywxtGjdataMapper.getPageList();
        PageInfo<YwxtGjdataWithBLOBs> pageInfo = new PageInfo<YwxtGjdataWithBLOBs>(list);
        return pageInfo;
    };

    public int updateState(String [] ids){
        int effectRow = ywxtGjdataMapper.updateState(ids);
        return effectRow;
    }

    public YwxtGjdataWithBLOBs getObjById(String id){
        YwxtGjdataWithBLOBs obj = ywxtGjdataMapper.getObjById(id);
        return obj;
    }

    public YwxtGjdataWithBLOBs getObjByIp(String ip){
        YwxtGjdataWithBLOBs obj = ywxtGjdataMapper.getObjByIp(ip);
        return obj;
    }


    public List<Map> getYwtzByYwId(String ywid){
        List<Map> obj = ywxtGjdataMapper.getYwtzByYwId(ywid);
        return obj;
    }




}
