package com.biye.dao;

import com.biye.entity.User;
import com.biye.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

//	登陆用查找用户名密码是否匹配
	@Select("select * from user where user_name=#{username} and password = #{password}")
	List<Map<String,Object>> login(@Param("username")String username,@Param("password")String password);

//查找所有用户信息
	@Select("select * ,(case when a.role=0 then '管理员' when a.role=1 then '业主' end ) roler from user a left join user_info b on a.user_id = b.user_id left join room_info c  on a.user_id = c.user_id   ")
	List<Map<String,Object>> getAllUser();

//----------新增用户----------------------
	@Insert("INSERT INTO user (user_name,password,role) VALUES (#{b.userName},#{b.password},#{b.role})")
	int addUser(@Param("a")UserInfo userInfo, @Param("b")User user);


	@Insert("INSERT INTO user_info (user_id,name,phone,id_number,birthday,sex) VALUES ((SELECT user_id FROM user WHERE user_name =#{b.userName}),#{a.name},#{a.phone},#{a.idNumber},#{a.birthday},#{a.sex})")
	int addUserInfo(@Param("a")UserInfo userInfo, @Param("b")User user);
//------------------------------------------------------------------------
//--------修改用户信息----------------------------------------------------------
	@Update("UPDATE user a,user_info b SET a.user_name=#{a.userName},a.password=#{a.password},a.role=#{a.role},b.name=#{b.name},b.phone=#{b.phone},b.id_number=#{b.idNumber},b.birthday=#{b.birthday},b.sex=#{b.sex} WHERE a.user_id=b.user_id and a.user_id = #{a.userId}")
	int editTheUserInfoById(@Param("b")UserInfo userInfo, @Param("a")User user);

//--------删除用户信息-----------------------------------------------------------
	@Delete("DELETE FROM user  WHERE user_id =#{userId}")
	int deleteTheUserInfoById(User user);


	@Delete("DELETE FROM user_info  WHERE user_id =#{userId}")
	int deleteTheUserInfoById2(User user);

	@Select("select * from user a LEFT JOIN user_info b ON a.user_id = b.user_id LEFT JOIN room_info c ON b.user_id = c.user_id where a.user_id = #{user_id}")
	List<Map<String,Object>> getTheUserInfoById(@Param("user_id")Long user_id);
}
