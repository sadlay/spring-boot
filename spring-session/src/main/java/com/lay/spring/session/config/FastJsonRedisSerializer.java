package com.lay.spring.session.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletContainerInitializer;
import java.nio.charset.Charset;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:08 2019/1/15
 * @Modified By:IntelliJ IDEA
 */
@Component("springSessionDefaultRedisSerializer")
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");


    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return null;
        }
        return JSONObject.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        return (T) JSONObject.parse(bytes);
    }

}
