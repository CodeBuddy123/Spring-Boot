package com.ashsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WishController {
    
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHelloForm()
	{
		return "helloform";
	}
	
	@RequestMapping(value = "/wish", method = RequestMethod.POST)
	public String wish(String uname, ModelMap map)
	{
		map.addAttribute("uname",uname);
		return "wish";
	}
}
