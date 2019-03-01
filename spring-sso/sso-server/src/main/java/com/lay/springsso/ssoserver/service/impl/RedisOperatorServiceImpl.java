package com.lay.springsso.ssoserver.service.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lay.springsso.ssoserver.entity.TokenSession;
import com.lay.springsso.ssoserver.service.RedisOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void initRedis(){
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
    }

    @Override
    public void putUserInfo(String userName, String token) {
        HashOperations<String, String, String> hashUserOp = redisTemplate.opsForHash();
       // RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        //redisTemplate.setHashValueSerializer(redisSerializer);
        hashUserOp.put(USER_KEY,userName,token);

    }

    @Override
    public void putTokenInfo(String tokenKey, TokenSession tokenSession) {
        HashOperations<String, String, TokenSession> hashTokenOp = redisTemplate.opsForHash();
        //RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        //redisSerializer = new JdkSerializationRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        //redisTemplate.setHashValueSerializer(redisSerializer);
        hashTokenOp.put(TOKEN_KEY,tokenKey,tokenSession);
    }

    @Override
    public String getUserInfo(String userName) {
        HashOperations<String, String, String> hashUserOp = redisTemplate.opsForHash();
        //RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        //redisSerializer = new StringRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        //redisTemplate.setHashValueSerializer(redisSerializer);
        return hashUserOp.get(USER_KEY, userName);
    }

    @Override
    public TokenSession getTokenInfo(String tokenKey) {
        HashOperations<String, String, TokenSession> hashTokenOp = redisTemplate.opsForHash();
        //RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        //redisSerializer = new JdkSerializationRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        //redisTemplate.setHashValueSerializer(redisSerializer);
        return hashTokenOp.get(TOKEN_KEY,tokenKey);
    }

    @Override
    public void deleteUserInfo(String userName) {
        HashOperations<String, String, String> hashUserOp = redisTemplate.opsForHash();
        //RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        //redisSerializer = new StringRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
        //redisTemplate.setHashValueSerializer(redisSerializer);
        hashUserOp.delete(USER_KEY,userName);
    }

    @Override
    public void deleteTokenInfo(String tokenKey) {
        HashOperations<String, String, TokenSession> hashTokenOp = redisTemplate.opsForHash();
       //RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        //redisSerializer = new JdkSerializationRedisSerializer();
        //redisSerializer = new Jackson2JsonRedisSerializer<>(TokenSession.class);
       // redisTemplate.setHashValueSerializer(redisSerializer);
        hashTokenOp.delete(TOKEN_KEY,tokenKey);
    }
}
