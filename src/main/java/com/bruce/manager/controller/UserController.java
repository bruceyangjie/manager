package com.bruce.manager.controller;

import com.bruce.manager.result.ResultEntity;
import com.bruce.manager.result.ResultTool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bruce on 19/5/23 -- 19:17
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping("/all")
    public ResultEntity getAll() {
        return ResultTool.ok();
    }

    @RequiresPermissions("/user/test")
    @GetMapping("/index")
    public ResultEntity index() {
        return ResultTool.ok();
    }

    @RequiresRoles("admin")
    @GetMapping("/test")
    public ResultEntity test() {
        return ResultTool.ok();
    }

    @RequiresRoles("tom")
    @GetMapping("/error")
    public ResultEntity error() {
        return ResultTool.ok();
    }

    @GetMapping("/login")
    public ResultEntity login(String userName, String passWord) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResultTool.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultTool.fail();
        }
    }
}
