package com.lay.springsso.ssoclient.service;

/**
 * @Description: 维护局部会话状态
 * @Author: lay
 * @Date: Created in 16:31 2019/2/20
 * @Modified By:IntelliJ IDEA
 */
public interface UserAccessService {

    String getUserToken(String user);

    void putUserStatus(String user,String ssoToken);

    void deleteToken(String ssoToken);
}
