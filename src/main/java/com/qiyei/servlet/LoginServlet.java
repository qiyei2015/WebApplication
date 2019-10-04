package com.qiyei.servlet;

import com.qiyei.common.CommonConstant;
import com.qiyei.domain.bean.User;
import com.qiyei.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2019/10/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: LoginServlet
 */
public class LoginServlet extends HttpServlet {

    private static final String TAG = "LoginServlet";

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用request.getParameter获取请求信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LogUtils.println(TAG,"username:" + username + ",password:" + password);
        //从ServletContext域中获得保存用户信息集合
        List<User> list = (List<User>) getServletContext().getAttribute(CommonConstant.KEY_USER_LIST);
        for (User user :list){
            //判断用户名密码是否正确
            if (username.equals(user.getUserName()) && password.equals(user.getPassword())){
                //是否记住密码
                String remember = request.getParameter("remember");
                if ("true".equals(remember)){
                    //设置cookie
                    Cookie cookie = new Cookie(CommonConstant.KEY_USERNAME,username);
                    //设置有效路径和有效时间
                    cookie.setPath(request.getContextPath() + "/login");
                    cookie.setMaxAge(60*60*24);
                    //将cookie写回浏览器
                    response.addCookie(cookie);
                }

                //将用户信息保存到session中
                request.getSession().setAttribute(CommonConstant.KEY_USER,user);
                response.sendRedirect(request.getContextPath()+"/login/success.jsp");
                return;
            }
        }

        // 登录失败:
        request.setAttribute(CommonConstant.KEY_MESSAGE, "用户名或密码错误！");
        request.getRequestDispatcher("/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
