package com.lay.springsso.ssoserver.service;

import com.lay.springsso.ssoserver.entity.TokenSession;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:24 2019/2/20
 * @Modified By:IntelliJ IDEA
 */
public interface RedisOperatorService {

    void putUserInfo(String userName, String token);

    void putTokenInfo(String tokenKey, TokenSession tokenSession);

    String getUserInfo(String userName);

    TokenSession getTokenInfo(String tokenKey);

    void deleteUserInfo(String userName);

    void deleteTokenInfo(String tokenKey);
}
