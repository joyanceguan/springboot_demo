package com.joyance.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joyance.springboot.demo.transaction.MyTransaction;

@Controller
@RequestMapping("/trans")
public class TransactionController {
	
	@Autowired
	MyTransaction myTransaction;

	@RequestMapping("/save")
	@ResponseBody
	public String save() throws Exception{
		return myTransaction.saveRoleAndConfig();
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(Integer roleId,Integer configId) throws Exception{
		myTransaction.deleteRoleAndConfig(roleId, configId);
	}
}
