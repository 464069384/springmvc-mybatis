package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@Controller
public class TestDicrict {
	@RequestMapping("/load")
	public String load(String id,RedirectAttributesModelMap map){
//		RedirectAttributesModelMap 加入的值相当于XXX ？key= value
		map.addAttribute("a","a");
		return "redirect:aaa";
	}
	
	@RequestMapping("/aaa")
	@ResponseBody
	public String testModel(String a){
		return a;
	} 
	
}
