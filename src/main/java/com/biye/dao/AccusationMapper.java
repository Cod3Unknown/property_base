package com.biye.dao;

import com.biye.entity.Accusation;
import com.biye.entity.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @描述:
 */

@Mapper
public interface AccusationMapper {


//    添加投诉信息
    @Insert("INSERT INTO accusation (user_id,user_remark,insert_time) VALUES (#{a.userId},#{a.userRemark},now())")
    int addTheAccusationInfo(@Param("a") Accusation accusation );

//按用户id查找投诉信息
    @Select("select *,(select name from user_info where user_id = b.admin_id) from user_info a LEFT JOIN accusation b ON a.user_id = b.user_id LEFT JOIN room_info c ON a.user_id = c.user_id where a.user_id = #{userId}")
    List<Map<String,Object>> getTheAccusationInfoById(Accusation accusation);

//查看某条
    @Select("select *,(select name from user_info where user_id = b.admin_id) from user_info a LEFT JOIN accusation b ON a.user_id = b.user_id LEFT JOIN room_info c ON a.user_id = c.user_id where b.accu_id = #{accuId}")
    List<Map<String,Object>> getTheAccusationInfoByAccId(Accusation accusation);

//查看所有投诉信息
    @Select("select * ,(select name from user_info where user_id = b.admin_id) admin_name from user_info a LEFT JOIN accusation b ON a.user_id = b.user_id LEFT JOIN room_info c ON a.user_id = c.user_id ")
    List<Map<String,Object>> getAllAccusationInfo();

//  接取投诉任务
    @Update("update accusation set admin_id = #{adminId},start_time = now(),status='1' where accu_id = #{accuId} ")
    Integer takeTheAccusationInfoByAccId(Accusation accusation);

//  完成投诉任务
    @Update("update accusation set admin_remark = #{adminRemark},end_time = now(),status='2' where accu_id = #{accuId} ")
    Integer completeTheAccusationInfoByAccId(Accusation accusation);
}
