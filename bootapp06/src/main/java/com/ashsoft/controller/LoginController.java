package com.ashsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
   
	@RequestMapping(value = "/loginpage", method =RequestMethod.GET)
	public String getLoginForm()
	{
		return "loginform";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String uname, @RequestParam String upwd,ModelMap map)
	{
		String status="";
		map.addAttribute("uname",uname);
		
		if(uname.equalsIgnoreCase("ashish") && upwd.equals("ashish"))
		{
			status="success";
		}
		else
		{
			status="failure";
		}
		return status;
	}
}
