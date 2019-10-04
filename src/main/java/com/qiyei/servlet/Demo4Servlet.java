package com.qiyei.servlet;

import javax.servlet.ServletContext;
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
 * @description: for 转发和重定向传递数据
 */
@WebServlet("/Demo4Servlet")
public class Demo4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //转发
        request.setAttribute("userName","大爷大爷");
        request.getRequestDispatcher("/login/demo4.jsp").forward(request,response);

        //重定向 使用ServletContext传递数据
        ServletContext sc = this.getServletContext();
        sc.setAttribute("goods", "娃娃");
        response.sendRedirect("/WebApplication/login/demo4.jsp");
    }
}
