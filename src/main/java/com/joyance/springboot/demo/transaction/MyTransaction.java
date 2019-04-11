package com.joyance.springboot.demo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.joyance.springboot.demo.mapper.ConfigMapper;
import com.joyance.springboot.demo.mapper.RoleMapper;
import com.joyance.springboot.demo.persistence.Config;
import com.joyance.springboot.demo.persistence.Role;

@Service
public class MyTransaction {

	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	ConfigMapper configMapper;
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public String saveRoleAndConfig() throws Exception{
		Role role = new Role();
		role.setRole_name("测试事务角色");
		int flag = roleMapper.save(role);
		System.out.println("新增角色id = "+role.getId());
		if(flag == 1){
			throw new Exception("error");
		}
		Config config = new Config();
		config.setC_desc("测试事务");
		config.setC_key("abc_key");
		config.setC_value("abc_value");
		flag = configMapper.save(config);
		return "新增角色id = "+role.getId()+",配置id = "+config.getId();
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteRoleAndConfig(Integer roleId,Integer configId) throws Exception{
		roleMapper.deleteRole(roleId);
		configMapper.deleteById(configId);
	}
	
}
