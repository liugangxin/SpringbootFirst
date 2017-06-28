package com.liu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liu.model.User;
import com.liu.service.UserService;
import com.liu.service.UserService2;

@RestController
//@EnableConfigurationProperties({ User.class })
@RequestMapping("/user")
public class UserController {

	/*@Autowired
	User user;*/

	@Autowired
	UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> getAccounts() {
		return userService.findUserList();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getAccountById(@PathVariable("userId") int userId) {
		return userService.findUser(userId);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public String updateAccount(@PathVariable("userId") int userId,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) double password) {
		int t = userService.update(name, password, userId);
		if (t == 1) {
			return "success";
		} else {
			return "fail";
		}

	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "userId") int userId) {
		int t = userService.delete(userId);
		if (t == 1) {
			return "success";
		} else {
			return "fail";
		}

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postAccount(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") double password) {

		int t = userService.add(name, password);
		if (t == 1) {
			return "success";
		} else {
			return "fail";
		}

	}

}
