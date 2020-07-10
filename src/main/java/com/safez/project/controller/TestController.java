package com.safez.project.controller;


import com.safez.project.entity.TestEntity;
import com.safez.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demoproject/test")
//@Api(value="测试controller",tags={"测试接口"})
@RestController
public class TestController {

    @Autowired
    private TestService testService;

//    @ApiOperation(value="获取用户信息",tags={"获取用户信息"},notes="注意问题点")
    @GetMapping(value = "/get/{id}")
    public TestEntity test(@PathVariable Integer id){
        System.out.println("id:" + id);
        return testService.getById(id);
    }

}
