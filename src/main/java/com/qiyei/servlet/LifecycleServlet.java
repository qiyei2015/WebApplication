package com.qiyei.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Created by qiyei2015 on 2019/10/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 也可以这样写 @WebServlet(LifecycleServlet")
 */
@WebServlet(name = "LifecycleServlet", value = "/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifecycleServlet 正在执行init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifecycleServlet 正在执行service");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("LifecycleServlet 正在执行destroy");
    }
}
