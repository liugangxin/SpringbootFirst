package com.liu.dao;

import org.apache.ibatis.annotations.Param;

import com.liu.model.User;

public interface UserDao2 {
	int update(@Param("name") String name, @Param("password") double password, @Param("userId") int userId);

	User findUser(@Param("userId") int userId);
}
