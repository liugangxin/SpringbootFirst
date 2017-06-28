package com.liu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 如果application.properties就不需要@PropertySource
@Configuration
@PropertySource(value = "classpath:my.properties")
@ConfigurationProperties(prefix = "my")
public class User {

	public int userId;
	@Value("${my.name}")
	public String name;
	public int password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	/*
	 * 表table结构： CREATE TABLE `user` ( `userId` INT(11) UNSIGNED NOT NULL
	 * AUTO_INCREMENT, `name` VARCHAR(20) NOT NULL, `password` VARCHAR(20) NOT
	 * NULL, PRIMARY KEY (`userId`) ) COLLATE='utf8_general_ci' ENGINE=InnoDB
	 * AUTO_INCREMENT=4 ;
	 */
}
