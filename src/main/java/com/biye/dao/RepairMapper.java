package com.biye.dao;

import com.biye.entity.Repair;
import com.biye.entity.User;
import com.biye.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


/**
 * @描述:
 */
@Mapper
public interface RepairMapper {

    @Insert("INSERT INTO repair (user_id,user_remark,insert_time) VALUES (#{a.userId},#{a.userRemark},now())")
    int addTheRepairInfo(@Param("a") Repair repair );


    @Select("select * from user_info a,repair b,room_info c where a.user_id = b.user_id and a.user_id = c.user_id  and a.user_id = #{userId}")
    List<Map<String,Object>> getTheRepairInfoById(Repair repair);

}
