package com.biye.controller;

import com.biye.service.LoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.biye.response.Result;

import javax.annotation.Resource;

/**
 * @描述:
 */

@CrossOrigin
@RestController
@RequestMapping("/Login")
public class LoginController {


    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public Object getUser(@RequestParam(name="username",required=true)String username,
                          @RequestParam(name="password",required=true)String password) {

        Object obj = null;
        try {
            obj   = loginService.login(username,password);
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.print(obj);
        return new Result().success(obj);
    }





}
