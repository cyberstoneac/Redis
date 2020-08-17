package com.redis.exaple.redis.demo.repository.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.exaple.redis.demo.repository.RedisRepository;

@Repository
public class RedisRepositoryImpl implements RedisRepository {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void setKey(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
		redisTemplate.expire(key, 10, TimeUnit.SECONDS);
	}

	@Override
	public String getKey(String key) {
		return (String) redisTemplate.opsForValue().get(key);
	}

}
