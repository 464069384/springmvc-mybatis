package com.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class ResponseController {
	@RequestMapping(value="/testRegist",method =RequestMethod.GET)
	@JsonView(Regist.class)//获得所有的get方法   json
	public Regist testRegist(){
		return new Regist();
	}
	//return  {"string":"Regist [username=null, password=null]","regist":"aaaa"}
}

class Regist{

	private String username;
	private String password;

	public String getRegist(){
		return "aaaa";
	}
	
	public String getString() {
		return "Regist [username=" + username + ", password=" + password + "]";
	}
	
}
