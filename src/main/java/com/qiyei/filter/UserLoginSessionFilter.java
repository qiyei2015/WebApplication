package com.qiyei.filter;

import com.qiyei.common.CommonConstant;
import com.qiyei.domain.bean.User;
import com.qiyei.utils.LogUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Created by qiyei2015 on 2019/10/13.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class UserLoginSessionFilter implements Filter {

    private static final String TAG = UserLoginSessionFilter.class.getSimpleName();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession().getAttribute(CommonConstant.KEY_USER);
        LogUtils.println(TAG,"doFilter user:" + (user == null ? "null" : user.toString()));
        //未登录
        if (user == null){
            // 未登录，系统强制重定向至登录页面
            response.sendRedirect(request.getContextPath() + "/login/login.jsp");
            return;
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

}
