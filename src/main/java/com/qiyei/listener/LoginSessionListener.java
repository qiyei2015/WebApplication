package com.qiyei.listener;

import com.qiyei.cache.LoginCache;
import com.qiyei.common.CommonConstant;
import com.qiyei.domain.bean.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author Created by qiyei2015 on 2019/10/13.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LoginSessionListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String attrName = se.getName();
        //登陆的
        if (CommonConstant.KEY_USER.equals(attrName)){
            User user = (User) se.getValue();
            HttpSession session = se.getSession();
            String sessionId = session.getId();

            String cacheSessionId = LoginCache.getInstance().getSessionIdByUser(user);
            //清除上次登陆的信息
            if (cacheSessionId != null){
                HttpSession cacheSession = LoginCache.getInstance().getSessionBySessionId(cacheSessionId);
                cacheSession.invalidate();
            }
            LoginCache.getInstance().setSessionIdByUser(user,sessionId);
            LoginCache.getInstance().setSessionBySessionId(sessionId,session);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
}
