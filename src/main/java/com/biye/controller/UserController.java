package com.biye.controller;

import com.biye.entity.Accusation;
import com.biye.entity.Repair;
import com.biye.entity.User;
import com.biye.entity.UserInfo;
import com.biye.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 */

@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/getUserInfoById")
    public Object getTheUserInfoById(Long user_id){
        List<Map<String, Object>> a =  userService.getTheUserInfoById(user_id);
        return a;
    }


    @RequestMapping("/editUserInfoById")
    public Object editTheUserInfoById(UserInfo userInfo,User user){
        Integer a =  userService.editTheUserInfoById(userInfo,user);
        return a;
    }

    @RequestMapping("/deleteUserInfoById")
    public Object deleteUserInfoById(User user){
        Integer a =  userService.deleteTheUserInfoById(user);
        return a;
    }




    @RequestMapping("/addTheAccusationInfo")
    public Object addTheAccusationInfo(Accusation accusation){
        Integer a = userService.addTheAccusationInfo(accusation);
        return a;
    }

    @RequestMapping("/getTheAccusationInfoById")
    public Object getTheAccusationInfoById(Accusation accusation){
        List<Map<String, Object>> a =  userService.getTheAccusationInfoById(accusation);
        System.out.println(a);
        return a;
    }


    @RequestMapping("/addTheRepairInfo")
    public Object addTheRepairInfo(Repair repair){
        Integer a = userService.addTheRepairInfo(repair);
        return a;
    }

    @RequestMapping("/getTheRepairInfoById")
    public Object getTheRepairInfoById(Repair repair){
        List<Map<String, Object>> a =  userService.getTheRepairInfoById(repair);
        System.out.println(a);
        return a;
    }

}
