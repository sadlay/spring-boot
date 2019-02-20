package com.lay.springsso.ssoserver.service.impl;

import com.lay.springsso.ssoserver.entity.TokenSession;
import com.lay.springsso.ssoserver.service.RedisOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:25 2019/2/20
 * @Modified By:IntelliJ IDEA
 */
@Service
public class RedisOperatorServiceImpl implements RedisOperatorService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public static final String USER_KEY = "userMap";

    public static final String TOKEN_KEY = "tokenMap";

    @Override
    public void putUserInfo(String userName, String token) {
        HashOperations<String, String, String> hashUserOp = redisTemplate.opsForHash();
        RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        redisTemplate.setHashValueSerializer(redisSerializer);
        hashUserOp.put(USER_KEY,userName,token);

    }

    @Override
    public void putTokenInfo(String tokenKey, TokenSession tokenSession) {
        HashOperations<String, String, TokenSession> hashTokenOp = redisTemplate.opsForHash();
        RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        redisSerializer = new JdkSerializationRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        redisTemplate.setHashValueSerializer(redisSerializer);
        hashTokenOp.put(TOKEN_KEY,tokenKey,tokenSession);
    }

    @Override
    public String getUserInfo(String userName) {
        HashOperations<String, String, String> hashUserOp = redisTemplate.opsForHash();
        RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        redisSerializer = new StringRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        redisTemplate.setHashValueSerializer(redisSerializer);
        return hashUserOp.get(USER_KEY, userName);
    }

    @Override
    public TokenSession getTokenInfo(String tokenKey) {
        HashOperations<String, String, TokenSession> hashTokenOp = redisTemplate.opsForHash();
        RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        redisSerializer = new JdkSerializationRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        redisTemplate.setHashValueSerializer(redisSerializer);
        return hashTokenOp.get(TOKEN_KEY,tokenKey);
    }

    @Override
    public void deleteUserInfo(String userName) {
        HashOperations<String, String, String> hashUserOp = redisTemplate.opsForHash();
        RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        redisSerializer = new StringRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        redisTemplate.setHashValueSerializer(redisSerializer);
        hashUserOp.delete(USER_KEY,userName);
    }

    @Override
    public void deleteTokenInfo(String tokenKey) {
        HashOperations<String, String, TokenSession> hashTokenOp = redisTemplate.opsForHash();
        RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        redisSerializer = new JdkSerializationRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        redisTemplate.setHashValueSerializer(redisSerializer);
        hashTokenOp.delete(TOKEN_KEY,tokenKey);
    }
}
