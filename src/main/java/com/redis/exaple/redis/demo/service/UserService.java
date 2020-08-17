package com.redis.exaple.redis.demo.service;

import com.redis.exaple.redis.demo.model.User;

public interface UserService {

	public void setKey(int key, User user);

	public String getKey(int key);
	
}
