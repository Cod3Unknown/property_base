package com.biye.service.impl;

import com.biye.dao.AccusationMapper;
import com.biye.dao.RepairMapper;
import com.biye.dao.UserMapper;
import com.biye.entity.Accusation;
import com.biye.entity.Repair;
import com.biye.entity.User;
import com.biye.entity.UserInfo;
import com.biye.service.UserService;
import com.github.pagehelper.PageInfo;
import com.biye.utils.ServiceResult;
import org.apache.ibatis.annotations.Insert;
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
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    RepairMapper repairMapper;
    @Resource
    AccusationMapper accusationMapper;

    @Override
    public List<Map<String,Object>> getTheUserInfoById(Long user_id){
        List<Map<String,Object>> a = userMapper.getTheUserInfoById(user_id);
        return  a;
    }

    @Override
    public Integer editTheUserInfoById(UserInfo userInfo, User user){
        Integer Oo0oO = userMapper.editTheUserInfoById(userInfo,user);
        return Oo0oO;
    }

    @Override
    public Integer deleteTheUserInfoById(User user){
        System.out.println(user.toString());
        Integer Oo0oO = userMapper.deleteTheUserInfoById(user);
        Integer Oo0oO2 = 0;
        if (Oo0oO==1) {
             Oo0oO2 = userMapper.deleteTheUserInfoById2(user);
        }
        System.out.println(Oo0oO);
        System.out.println(Oo0oO2);
        return Oo0oO2;
    }

    @Override
    public Integer addTheRepairInfo(Repair repair){
        Integer a = repairMapper.addTheRepairInfo(repair);
        System.out.println("aaaaaaaaaaaaaa");
        System.out.println(a);
        return a;
    }

    @Override
    public List<Map<String,Object>> getTheRepairInfoById(Repair repair){
        List<Map<String,Object>> a = repairMapper.getTheRepairInfoById(repair);
//        System.out.println(a);
        return a;
    }

    @Override
    public Integer addTheAccusationInfo(Accusation accusation){
        Integer a = accusationMapper.addTheAccusationInfo(accusation);
        return a;
    }

    @Override
    public List<Map<String,Object>> getTheAccusationInfoById(Accusation accusation){
        List<Map<String,Object>> a = accusationMapper.getTheAccusationInfoById(accusation);
        System.out.println(a);
        return a;
    }





}
