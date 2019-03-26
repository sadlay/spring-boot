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
    public static TokenSession TOKEN_SESSION;

    private static final ThreadLocal<TokenSession> localSession = new ThreadLocal<TokenSession>() {
/*        @Override
        protected TokenSession initialValue() {
            return TOKEN_SESSION;
        }*/
    };

    public static void set(TokenSession tokenSession) {
        localSession.set(tokenSession);
    }

    public static TokenSession getTokenSession() {
        TokenSession tokenSession = localSession.get();
        return tokenSession;
    }

    public static void remove() {
        localSession.remove();
    }


    public static void setStaticSession(TokenSession tokenSession) {
        LocalUtil.TOKEN_SESSION = tokenSession;
    }

    public static TokenSession getStaticSession() {
        return TOKEN_SESSION;
    }


    public static void removeStaticSession() {
        TOKEN_SESSION = null;
    }
}
