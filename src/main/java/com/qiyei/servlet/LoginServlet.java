package com.qiyei.servlet;

import com.qiyei.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        LogUtils.println(TAG,"account:" + account);
        LogUtils.println(TAG,"password:" + password);

        if ("101".equals(account) && "123456".equals(password)){
            //1 使用转发实现
            //request.getRequestDispatcher("/login/success.jsp").forward(request,response);
            //2 使用重定向实现
            response.sendRedirect("/WebApplication/success.jsp");
        }else {
            //1 使用转发实现
            //request.getRequestDispatcher("/login/fail.jsp").forward(request,response);
            //2 使用重定向实现
            response.sendRedirect("/WebApplication/login/fail.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
