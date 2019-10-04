package com.qiyei.utils;

import javax.servlet.http.Cookie;

/**
 * @author Created by qiyei2015 on 2019/10/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class CookieUtils {

    public static Cookie findCookie(Cookie[] cookies, String name){
        if(cookies == null){
            // 说明客户端没有携带Cookie:
            return null;
        }else{
            // 说明客户端携带Cookie:
            for (Cookie cookie : cookies) {
                if(name.equals(cookie.getName())){
                    return cookie;
                }
            }
            return null;
        }
    }
}
