package com.ashsoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
   
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "<h1 style='color:blue' align='center'>Hello From Eclipse</h1>";
	}
}
