package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.Userdao;
import com.springmvc.model.User;

@Service
public class UserService {
	@Autowired
	private Userdao userdao;
	
	public int createUser(User user) {
		return this.userdao.saveUser(user);
		
	}
}
