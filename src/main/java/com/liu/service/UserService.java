package com.liu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liu.dao.UserDao;
import com.liu.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public int add(String name, double money) {
		return userDao.add(name, money);
	}

	@Transactional
	public int update(String name, double money, int id) throws RuntimeException {
		// do something, 这里只是使用事务示例
		return userDao.update(name, money, id);
	}

	public int delete(int id) {
		return userDao.delete(id);
	}

	public User findUser(int userId) {
		return userDao.findUser(userId);
	}

	public List<User> findUserList() {
		return userDao.findUserList();
	}
}
