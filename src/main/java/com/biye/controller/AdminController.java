package com.biye.controller;

import com.biye.entity.*;
import com.biye.service.AdminService;
import com.biye.service.LoginService;
import com.biye.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 */
@CrossOrigin
@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Resource
    AdminService adminService;

    @Resource
    UserService userService;


    //查看所有用户
    @RequestMapping("/getAllUser")
    public Object getAllUser(){
        return adminService.getAllUser();
    }


//    nusername;
//  npassword;
//  nphone;
//  nidNumber;
//  nsex;
//  nbirthday;
    //新增用户
    @RequestMapping("/addUser")
    public Object addUser(UserInfo userInfo , User user){
//        System.out.println(userInfo.toString());
//        System.out.println(user.toString());
        int a;
        int b = 0;
        a = adminService.addUser(userInfo,user);
        if (a == 1){
            b = adminService.addUserInfo(userInfo,user);
        }

        return b;
    }


    //查看房间信息
    @RequestMapping("/getRoomInfo")
    public Object getRoomInfo(){
        return adminService.getRoomInfo();
    }

//插入房间信息
    @RequestMapping("/addTheRepairInfo")
    public Object addTheRepairInfo(RoomInfo roomInfo){

        Integer a = adminService.addRoomInfo(roomInfo);
        return a;
    }

//    获取所有投诉信息
    @RequestMapping("/getAllAccusationInfo")
    public Object getAllAccusationInfo(){
        List<Map<String, Object>> a =  adminService.getAllAccusationInfo();
        System.out.println(a);
        return a;
    }

    //    获取当前投诉信息
    @RequestMapping("/getTheAccusationInfoByAccId")
    public Object  getTheAccusationInfoByAccId(Accusation accusation){
        List<Map<String, Object>> a =  adminService.getTheAccusationInfoByAccId(accusation);
        return a;
    }

    //    接取投诉任务
    @RequestMapping("/takeTheAccusationInfoByAccId")
    public Object  takeTheAccusationInfoByAccId(Accusation accusation){
        Integer a =  adminService.takeTheAccusationInfoByAccId(accusation);
        return a;
    }

    //    完成投诉任务
    @RequestMapping("/completeTheAccusationInfoByAccId")
    public Object  completeTheAccusationInfoByAccId(Accusation accusation){
        Integer a =  adminService.completeTheAccusationInfoByAccId(accusation);
        return a;
    }

}
