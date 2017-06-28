package com.liu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello/{Id}")
	String home() {
		return "Hello World!";
	}

}
