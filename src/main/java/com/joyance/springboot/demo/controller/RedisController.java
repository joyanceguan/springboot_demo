package com.joyance.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joyance.springboot.demo.persistence.Role;
import com.joyance.springboot.demo.redis.RedisService;

@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	RedisService redisService;

	@RequestMapping("/saveHello")
	@ResponseBody
	public String saveHello(){
		return redisService.saveHello();
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(){
		return redisService.delete();
	}
	
	@RequestMapping("/getHello")
	@ResponseBody
	public String getHello(){
		return redisService.getHello();
	}
	
	@RequestMapping("/saveObject")
	@ResponseBody
	public String saveObject(){
		return redisService.saveObject();
	}
	
	@RequestMapping("/getObject")
	@ResponseBody
	public Role getObject(){
		return redisService.getObject();
	}
}
