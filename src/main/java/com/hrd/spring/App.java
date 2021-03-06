package com.hrd.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.mangofactory.swagger.plugin.EnableSwagger;

@EnableAutoConfiguration
@ComponentScan("com.hrd.spring")
@EnableSwagger
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
