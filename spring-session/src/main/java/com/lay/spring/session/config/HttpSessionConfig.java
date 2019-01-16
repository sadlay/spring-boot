package com.lay.spring.session.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.SessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:19 2019/1/15
 * @Modified By:IntelliJ IDEA
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {
    @Autowired
    private RedisOperationsSessionRepository redisOperationsSessionRepository;

    /**
     *  设置 redisTemplate 序列化方式
     * @param factory
     * @return
     */
    //@Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        // 设置值（value）的序列化采用FastJsonRedisSerializer。
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>();
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        // 设置键（key）的序列化采用StringRedisSerializer。
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setDefaultSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    //@Bean("redisOperationsSessionRepository")
    //@Primary
    public SessionRepository sessionRepository(@Autowired RedisTemplate redisTemplate){
        RedisOperationsSessionRepository sessionRepository=new RedisOperationsSessionRepository(redisTemplate);
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>();
        sessionRepository.setDefaultSerializer(fastJsonRedisSerializer);
        sessionRepository.setDefaultMaxInactiveInterval(36000);
        return sessionRepository;
    }

}
