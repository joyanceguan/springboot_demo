package com.joyance.springboot.demo.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.joyance.springboot.demo.persistence.Config;
import com.joyance.springboot.demo.service.ConfigService;

@RestController
@ApiVersion
// 在url中增加一个占位符，用于匹配未知的版本 v1 v2...
@RequestMapping("/api/{version}")
public class VersionController {

	@Autowired
	ConfigService configService;
	
	@ApiVersion(1)
	@RequestMapping("/getconfig")
	@ResponseBody
	public Config getConfig1(){
		Config config = configService.getConfig(1);
		return config;
	}
	
	@ApiVersion(2)
	@RequestMapping("/getconfig")
	@ResponseBody
	public Config getConfig2(){
		Config config = configService.getConfig(3);
		return config;
	}
	
	@ApiVersion(3)
	@RequestMapping("/getconfig")
	@ResponseBody
	public Config getConfig3(){
		Config config = configService.getConfig(4);
		return config;
	}
}
