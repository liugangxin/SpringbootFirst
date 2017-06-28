package com.liu.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liu.dao.UserDao2;
import com.liu.model.User;

//仅仅为了测试mybatis配置文件，可以直接用
@Service
@MapperScan("com.liu.dao")
public class UserService2 {
	@Autowired
	private UserDao2 userDao2;

	public int update(String name, double money, int id) {
		return userDao2.update(name, money, id);
	}

	public User findUser(int userId) {
		return userDao2.findUser(userId);
	}
}
