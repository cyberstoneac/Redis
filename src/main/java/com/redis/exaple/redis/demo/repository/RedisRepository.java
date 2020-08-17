package com.redis.exaple.redis.demo.repository;

public interface RedisRepository {

	public void setKey(String key, String value);

	public String getKey(String key);

}
