package com.joyance.springboot.demo.mapper;

import com.joyance.springboot.demo.persistence.Config;

public interface ConfigMapper {

	public int save(Config config);
	
	public int update(Config config);
	
	public Config selectById(Integer id);
	
	public int deleteById(Integer id);
	
	public Config getMIndexConfigByKey(String key);
}
