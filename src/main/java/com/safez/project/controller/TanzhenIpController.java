package com.safez.project.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.safez.project.entity.TanzhenIpWithBLOBs;
import com.safez.project.service.TanzhenIpService;
import com.safez.project.util.ApiToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tanzhenIp")
@Api(value="探针IPcontroller",tags={"探针IP接口"})
@RestController
public class TanzhenIpController {

    @Autowired
    TanzhenIpService tanzhenIpService;

    @ApiOperation(value="探针IP信息",tags={"探针IP信息"},notes="注意问题点")
    @GetMapping(value = "/get/{id}")
    @ApiToken
    public TanzhenIpWithBLOBs getById(@PathVariable Integer id){
        return tanzhenIpService.getById(id);
    }

    @ApiOperation(value="探针IP信息分页",tags={"探针IP信息分页"},notes="注意问题点")
    @GetMapping(value = "/getPageList")
    @ApiToken
    public PageInfo<TanzhenIpWithBLOBs> getPageList(Integer pageNum, Integer pageSize, String token){
        PageInfo<TanzhenIpWithBLOBs>  userList= tanzhenIpService.getPageList(pageNum,pageSize);
        return userList;
    }
}
