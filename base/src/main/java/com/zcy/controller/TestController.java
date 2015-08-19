package com.zcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String testSpringmvc(){
		ModelMap map = new ModelMap();
		map.addAttribute("a", "hello world");
		return "a";
	}
}
