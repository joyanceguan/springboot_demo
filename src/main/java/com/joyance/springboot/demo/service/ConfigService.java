package com.joyance.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyance.springboot.demo.mapper.ConfigMapper;
import com.joyance.springboot.demo.persistence.Config;

@Service
public class ConfigService {

	@Autowired
	ConfigMapper configMapper;
	
	public Config getConfig(Integer id){
		Config config = configMapper.selectById(id);
		return config;
	}
	
}
