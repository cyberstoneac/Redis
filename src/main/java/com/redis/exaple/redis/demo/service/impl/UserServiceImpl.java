package com.redis.exaple.redis.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.exaple.redis.demo.model.User;
import com.redis.exaple.redis.demo.repository.RedisRepository;
import com.redis.exaple.redis.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private RedisRepository redisRepository;

	@Override
	public void setKey(int key, User user) {
		redisRepository.setKey(String.valueOf(key), user.toString());
	}

	@Override
	public String getKey(int key) {
		return redisRepository.getKey(String.valueOf(key));
	}

}
