package com.qiyei.cache;

import com.qiyei.domain.bean.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2019/10/13.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LoginCache {

    private static LoginCache sInstance;

    // key值：登录用户，value值：登录用户sessionId
    private Map<User,String> mUserSessionMap = new HashMap<>();
    //key值:登录用户sessionId,value值：登录用户session对象
    private Map<String, HttpSession> mSessionMap = new HashMap<>();


    private LoginCache(){

    }

    public static LoginCache getInstance(){
        if (sInstance == null){
            synchronized (LoginCache.class){
                if (sInstance == null){
                    sInstance = new LoginCache();
                }
            }
        }
        return sInstance;
    }

    /**
     * 通过登录用户获取对应登录用户的sessionId
     * @param user
     * @return
     */
    public String getSessionIdByUser(User user){
        return mUserSessionMap.get(user);
    }

    /**
     * 通过sessionId获取对应的session对象
     * @param sessionId
     * @return
     */
    public HttpSession getSessionBySessionId(String sessionId){
        return mSessionMap.get(sessionId);
    }

    /**
     * 存储登录用户的登录sessionID至缓存对象
     * @param user
     * @param sessionId
     */
    public void setSessionIdByUser(User user, String sessionId){
        mUserSessionMap.put(user, sessionId);
    }

    /**
     * 存储sessionId与对应的session对象至缓存对象
     * @param sessionId
     * @param session
     */
    public void setSessionBySessionId(String sessionId,HttpSession session){
        mSessionMap.put(sessionId, session);
    }
}
