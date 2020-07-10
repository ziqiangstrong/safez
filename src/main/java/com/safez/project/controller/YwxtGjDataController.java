package com.safez.project.controller;

import com.github.pagehelper.PageInfo;
import com.safez.project.entity.YwxtGjdataWithBLOBs;
import com.safez.project.service.YwxtGjDataService;
import com.safez.project.util.ApiToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ywxt")
@Api(value="/gjdata",tags={"攻击报警"})
@RestController
public class YwxtGjDataController {

    @Autowired
    YwxtGjDataService ywxtGjDataService;


    @ApiOperation(value="攻击报警分页",tags={"攻击报警分页"},notes="")
    @GetMapping(value = "/getPageList")
    @ApiToken
    public PageInfo<YwxtGjdataWithBLOBs> getPageList(Integer pageNum, Integer pageSize, String token){
        PageInfo<YwxtGjdataWithBLOBs> userList= ywxtGjDataService.getPageList(pageNum,pageSize);
        return userList;
    }


    @ApiOperation(value="批量处理",tags={"批量处理"},notes="")
    @GetMapping(value="/batchDeal")
    @ApiToken
    public JSONObject batchDeal(String[] ids, String token){
        JSONObject result = new JSONObject();
        int effectRow= ywxtGjDataService.updateState(ids);
        if(effectRow>0){
            result.put("state","success");
            result.put("num",effectRow);
        }else{
            result.put("state","fail");
            result.put("num",0);
        }
        return result;
    }

    @ApiOperation(value="查看详情",tags={"查看详情"},notes="")
    @GetMapping(value="/getObj")
    @ApiToken
    public YwxtGjdataWithBLOBs  getObjById(String id, String token){
        YwxtGjdataWithBLOBs obj= ywxtGjDataService.getObjById(id);
        return obj;
    }






}
