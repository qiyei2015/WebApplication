package com.qiyei.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Created by qiyei2015 on 2019/10/5.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username","张三");
        request.setAttribute("age","28");

        request.getRequestDispatcher("/demo/showEL.jsp").forward(request,response);
    }
}
