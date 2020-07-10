package com.safez.project.controller;

import com.safez.project.entity.UserWithBLOBs;
import com.safez.project.service.UserService;
import com.safez.project.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Api(value="用户登录接口",tags={"登录接口"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value="用户登录",tags={"用户登录"},notes="")
    @PostMapping(value = "/login")
    @ResponseBody
    public JSONObject login(HttpServletRequest request,String username, String password){
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1000*60*60);
        System.out.println(session.getId());
        JSONObject result=new JSONObject();
        UserWithBLOBs user= userService.getUser(username);
        if (session.getAttribute(username) == null) {
            if (user.getPasswd().equals(password)) {
                session.setAttribute(username,session.getId());
                result.put("state","success");
                result.put("token",session.getId());
                result.put("message","登录成功！");
            }else{
                result.put("state","fail");
                result.put("message","登录失败！");
            }
        } else if (session.getAttribute(username) != null && session.getAttribute(username).equals(session.getId())) {
            result.put("state","fail");
            result.put("message","免登陆！");
        }
        return result;
    }

    /**
     * 用户登出
     * */
    @ApiOperation(value="用户登出",tags={"用户登出"},notes="")
    @PostMapping(value = "/logout")
    @ResponseBody
    public JSONObject logout(String username,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1000*60*60);
        System.out.println(session.getId());
        JSONObject result=new JSONObject();
        result.put("state","success");
        if (session.getAttribute(username)!=null && session.getAttribute(username).equals(session.getId())) {
            session.removeAttribute(username);
            result.put("message","用户已退出");
            return result;
        }
        result.put("message","用户已退出");
        return result;
    }


}
