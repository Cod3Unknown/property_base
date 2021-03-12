package com.biye.service;

import com.biye.entity.Accusation;
import com.biye.entity.RoomInfo;
import com.biye.entity.User;
import com.biye.entity.UserInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 */
public interface AdminService {

     Map<String,Object> getAllUser();

     Integer addUser(UserInfo userInfo, User user);

     Integer addUserInfo(UserInfo userInfo, User user);

     List<Map<String,Object>> getRoomInfo();

     Integer addRoomInfo(RoomInfo roomInfo);

     List<Map<String,Object>>getAllAccusationInfo();

     List<Map<String,Object>>getTheAccusationInfoByAccId(Accusation accusation);

     Integer  takeTheAccusationInfoByAccId(Accusation accusation);

     Integer completeTheAccusationInfoByAccId(Accusation accusation);

}
