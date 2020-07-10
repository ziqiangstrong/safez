package com.safez.project.controller;

import com.github.pagehelper.PageInfo;
import com.safez.project.entity.YwxtGjdataWithBLOBs;
import com.safez.project.service.YwxtHdSjService;
import com.safez.project.util.ApiToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/ywxt")
@Api(value="/hdsj",tags={"后端数据"})
@RestController
public class YwxtHdsjController {

    @Autowired
    YwxtHdSjService ywxtHdSjService;

    @ApiOperation(value="用户行为",tags={"用户行为"},notes="")
    @GetMapping(value="/getBehavior")
    @ApiToken
    public PageInfo<Map> getBehavior(Integer pageNum, Integer pageSize, String token){
        Map<String,Object> param = new HashMap<>();
        PageInfo<Map> obj= ywxtHdSjService.getUserBehavior(pageNum,pageSize,param);
        return obj;
    }

}
