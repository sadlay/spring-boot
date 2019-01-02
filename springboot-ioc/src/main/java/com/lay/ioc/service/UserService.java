package com.lay.ioc.service;

import org.springframework.stereotype.Service;

import com.lay.ioc.pojo.User;

@Service
public class UserService {
	public void showUser(User user) {
		System.out.println(user.getId());
		System.out.println(user.getUserName());
		System.out.println(user.getMessage());
	}
}
