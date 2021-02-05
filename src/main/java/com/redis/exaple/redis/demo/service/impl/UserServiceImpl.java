package com.redis.exaple.redis.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

import com.redis.exaple.redis.demo.model.User;
import com.redis.exaple.redis.demo.repository.RedisRepository;
import com.redis.exaple.redis.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private RedisRepository redisRepository;

	private Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<>(User.class);

	@Override
	public User setKey(int key, User user) {
		redisRepository.setKey(String.valueOf(key), new String(serializer.serialize(user)));
		return getKey(key);
	}

	@Override
	public User getKey(int key) {
		return serializer.deserialize(redisRepository.getKey(String.valueOf(key)).getBytes());
	}

}
