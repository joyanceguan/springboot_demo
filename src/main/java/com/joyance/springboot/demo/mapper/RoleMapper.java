package com.joyance.springboot.demo.mapper;

import java.util.List;
import com.joyance.springboot.demo.persistence.Role;

public interface RoleMapper {

	public int save(Role role);
	
	public Role selectById(Integer id);
	
	public List<Role> selectByIds(List<Integer> list);
	
	public int update(Role role);
	
	public List<Role> list();
	
	public int deleteRole(Integer id);
	
}
