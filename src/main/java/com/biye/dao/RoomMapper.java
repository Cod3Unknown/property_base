package com.biye.dao;

import com.biye.entity.Repair;
import com.biye.entity.RoomInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @描述:
 */
@Mapper
public interface RoomMapper {
//
    @Insert("INSERT INTO room_info (building,room_num,area) VALUES (#{building},#{roomNum},#{area})")
    int addTheRoomInfo(RoomInfo roomInfo);


    @Select("select * from room_info b left join user_info a on a.user_id = b.user_id left join room_info c on a.user_id = c.user_id")
    List<Map<String,Object>> getTheRoomInfo();

}
