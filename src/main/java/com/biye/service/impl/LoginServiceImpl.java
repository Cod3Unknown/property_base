package com.biye.service.impl;

import com.biye.dao.UserMapper;
import com.biye.service.LoginService;
import org.springframework.stereotype.Component;
import  com.biye.entity.User;
import javax.annotation.Resource;
import java.util.function.DoubleToIntFunction;

/**
 * @描述:
 */


@Component
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper ;

    @Override
    public Object  login(String username,String password) throws Exception {
        System.out.println(userMapper.login(username,password));
        return userMapper.login(username,password);
    }
}
