package com.joyance.springboot.demo.redis;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.joyance.springboot.demo.persistence.Role;

@Service
public class RedisService {

	@Autowired
    RedisTemplate<Object, Object> redisTemplate;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	private final static String HELLO = "HELLO";
	private final static String HASH = "HASH";
	
	public String saveHello(){
		stringRedisTemplate.opsForValue().set(HELLO, "hello world!!!");
		return "save success";
	}
	
	public String getHello(){
		String value = stringRedisTemplate.opsForValue().get(HELLO);
		return value;
	}
	
	public String delete(){
		stringRedisTemplate.delete(HELLO);
		redisTemplate.delete(HASH);
		return "delete success";
	}
	
	public String saveObject(){
		Role role = new Role();
		Date now = new Date();
		role.setCreate_time(now);
		role.setId(1);
		role.setRole_name("hello");
		role.setUpdate_time(now);
		redisTemplate.opsForHash().put(HASH, HELLO, role);
		return "put hash success";
	}
	
	public Role getObject(){
		Role role = (Role) redisTemplate.opsForHash().get(HASH, HELLO);
		return role;
	}
}
