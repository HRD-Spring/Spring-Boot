package com.hrd.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping("")
	@ResponseBody
	public String hello() {
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloController.class, args);
	}
}
