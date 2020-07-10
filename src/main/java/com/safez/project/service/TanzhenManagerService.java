package com.safez.project.service;

import com.safez.project.dao.TanzhengManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TanzhenManagerService {


    @Autowired
    private TanzhengManagerMapper tanzhengManagerMapper;


    /**
     * 获取所有的探针
     * @return
     */
    public List<Map>  getTanzhenAll(){
        List<Map> result = tanzhengManagerMapper.getTanzhenAll();
        return  result;
    }
}
