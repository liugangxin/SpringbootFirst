package com.liu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.liu.model.User;

@Mapper
public interface UserDao {
	@Insert("insert into user(name, password) values(#{name}, #{password})")
	int add(@Param("name") String name, @Param("password") double password);

	@Update("update user set name = #{name}, password = #{password} where userId = #{userId}")
	int update(@Param("name") String name, @Param("password") double money, @Param("userId") int userId);

	@Delete("delete from user where userId = #{userId}")
	int delete(int userId);

	@Select("select userId, name as name, password as password from user where userId = #{userId}")
	User findUser(@Param("userId") int userId);

	@Select("select userId, name as name, password as password from user")
	List<User> findUserList();
}
