package com.joyance.springboot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.joyance.springboot.demo.persistence.Config;
import com.joyance.springboot.demo.service.ConfigService;


@Controller
@RequestMapping("/config")
public class ConfigController {
	
	private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);
	
	@Autowired
	ConfigService configService;

	@RequestMapping("/getbyid")
	public ModelAndView getById(Integer id){
		Config config = configService.getConfig(id);
		ModelAndView mv = new ModelAndView("/config/detail");
		mv.addObject("config", config);
		return mv;
	}
	
	@RequestMapping("/getconfig")
	@ResponseBody
	public Config getConfig(Integer id){
		Config config = configService.getConfig(id);
		logger.info(JSON.toJSONString(config));
		return config;
	}
	
}
