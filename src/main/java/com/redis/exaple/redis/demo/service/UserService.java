package com.redis.exaple.redis.demo.service;

import com.redis.exaple.redis.demo.model.User;

public interface UserService {

	public User setKey(int key, User user);

	public User getKey(int key);

}
