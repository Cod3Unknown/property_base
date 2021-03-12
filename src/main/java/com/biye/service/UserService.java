package com.biye.service;

import com.biye.entity.Accusation;
import com.biye.entity.Repair;
import com.biye.entity.User;
import com.biye.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @描述:
 */
public interface UserService {

    List<Map<String,Object>> getTheUserInfoById(Long user_id);

    Integer editTheUserInfoById(UserInfo userInfo, User user);

    Integer deleteTheUserInfoById(User user);

    Integer addTheRepairInfo(Repair repair);

    List<Map<String,Object>> getTheRepairInfoById(Repair repair);

    Integer addTheAccusationInfo(Accusation accusation);

    List<Map<String,Object>> getTheAccusationInfoById(Accusation accusation);

    ;
}
