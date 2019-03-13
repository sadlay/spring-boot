package com.lay.springsso.ssoserver.test;

import com.lay.springsso.ssoserver.entity.TokenSession;
import org.apache.tomcat.jni.Pool;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 9:18 2019/3/13
 * @Modified By:IntelliJ IDEA
 */
public class LocalUtil {
    private static final TokenSession TOKEN_SESSION=new TokenSession("token1","username1");

    private static final ThreadLocal<TokenSession> localSession=new ThreadLocal<TokenSession>(){
/*        @Override
        protected TokenSession initialValue() {
            return new TokenSession("token1","username1");
        }*/
    };

    public static void set(TokenSession tokenSession){
        localSession.set(tokenSession);
    }
    public static TokenSession getTokenSession(){
        TokenSession tokenSession = localSession.get();
        //localSession.remove();
        return tokenSession;
    }

    public static void remove(){
        localSession.remove();
    }

}
