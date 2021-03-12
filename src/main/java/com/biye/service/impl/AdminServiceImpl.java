package com.biye.service.impl;

import com.biye.dao.AccusationMapper;
import com.biye.dao.RepairMapper;
import com.biye.dao.RoomMapper;
import com.biye.dao.UserMapper;
import com.biye.entity.Accusation;
import com.biye.entity.RoomInfo;
import com.biye.entity.User;
import com.biye.entity.UserInfo;
import com.biye.service.AdminService;
import com.github.pagehelper.PageInfo;
import com.biye.utils.ServiceResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 */

@Component
public class AdminServiceImpl implements AdminService {

    @Resource
    private UserMapper userMapper ;
    @Resource
    private RoomMapper roomMapper ;
    @Resource
    RepairMapper repairMapper;
    @Resource
    AccusationMapper accusationMapper;

    @Override
    public Map<String,Object> getAllUser(){
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        dataList= userMapper.getAllUser();
        System.out.println(dataList);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(dataList);
        return new ServiceResult(pageInfo).result();
    }


    @Override
    public Integer addUser(UserInfo userInfo, User user) {
        System.out.println(userInfo.toString());
        System.out.println(user.toString());
        int a=userMapper.addUser(userInfo,user);
//        if(a==1){
//            int b =userMapper.addUserInfo(user_name,phone,id_number,birthday,sex,name);
//            System.out.println(b);
//        }
//        System.out.println(a);

        return a;

    }


    @Override
    public Integer addUserInfo(UserInfo userInfo, User user) {
            int b =userMapper.addUserInfo(userInfo,user);
            System.out.println("b = "+b);
        return b;
    }

    @Override
    public List<Map<String,Object>> getRoomInfo(){
        List<Map<String,Object>> a =roomMapper.getTheRoomInfo();
        return a;
    }

    @Override
    public Integer addRoomInfo(RoomInfo roomInfo){
        System.out.println(roomInfo.toString());
        Integer a =roomMapper.addTheRoomInfo(roomInfo);
        return a;
    }

    @Override
    public List<Map<String,Object>>getAllAccusationInfo(){
        List<Map<String,Object>> a = accusationMapper.getAllAccusationInfo();
        return a;
    }

    @Override
    public List<Map<String,Object>>getTheAccusationInfoByAccId(Accusation accusation){
        List<Map<String,Object>> a = accusationMapper.getTheAccusationInfoByAccId(accusation);
        return a;
    }


    @Override
    public Integer  takeTheAccusationInfoByAccId(Accusation accusation){
        Integer Oo0oO = accusationMapper.takeTheAccusationInfoByAccId(accusation);
        return Oo0oO;

    }


    public Integer completeTheAccusationInfoByAccId(Accusation accusation){
        Integer Oo0oO = accusationMapper.completeTheAccusationInfoByAccId(accusation);
        return Oo0oO;
    }

}
