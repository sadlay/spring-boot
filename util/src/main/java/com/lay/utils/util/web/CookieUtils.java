package com.lay.utils.util.web;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: Cookie工具类
 * @Author: lay
 * @Date: Created in 14:35 2019/1/15
 * @Modified By:IntelliJ IDEA
 */
public class CookieUtils {
    /**
     * @param request
     * @Description: 获取所有Cookie
     * @return: javax.servlet.http.Cookie[]
     * @auther: lay
     * @date: 14:38 2019/1/15
     */
    public static Cookie[] getCookies(HttpServletRequest request) {
        return request.getCookies();
    }

    /**
     * @param request
     * @param name
     * @return javax.servlet.http.Cookie
     * @Description 根据名称获取指定cookie
     * @auther lay
     * @Date 14:42 2019/1/15
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        Cookie[] cookies = getCookies(request);
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * @param request
     * @param name
     * @Description: 根据名称获取指定cookie
     * @return: javax.servlet.http.Cookie
     * @auther: lay
     * @date: 14:42 2019/1/15
     */
    public static String getCookieValueByName(HttpServletRequest request, String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        Cookie[] cookies = getCookies(request);
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * @param response
     * @param name
     * @param value
     * @param maxAge
     * @Description: 添加Cookie
     * @return: boolean
     * @auther: lay
     * @date: 14:57 2019/1/15
     */
    public static boolean addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(value)) {
            return false;
        }
        Cookie cookie = new Cookie(name.trim(), value.trim());
        if (maxAge <= 0) {
            maxAge = -1;
        }
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }

    /**
     * @param request
     * @param response
     * @param name
     * @Description:删除Cookie 但是需要注意的是修改、删除Cookie时，除value、maxAge之外的所有属性，例如name、path、domain等，都要与原Cookie完全一样。否则，浏览器将视为两个不同的Cookie不予覆盖，导致修改、删除失败。
     * @param:
     * @return: boolean
     * @auther: lay
     * @date: 14:57 2019/1/15
     */
    public static boolean removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        if (StringUtils.isBlank(name)) {
            return false;
        }
        Cookie[] cookies = getCookies(request);
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    return true;
                }
            }
        }
        return false;
    }
}
