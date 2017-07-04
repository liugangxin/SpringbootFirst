package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/")
	String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/hello/{Id}")
	String home() {
		return "Hello World!";
	}
	

}
