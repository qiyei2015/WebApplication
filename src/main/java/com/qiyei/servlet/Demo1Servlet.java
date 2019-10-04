package com.qiyei.servlet;

import com.qiyei.utils.LogUtils;

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
 * @description:
 *
 * ServletContext 表示是整个javaWeb工程
 * ServletConfig 表示的是某一个Servlet的配置文件
 */
@WebServlet("/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {

    private static final String TAG = "Demo1Servlet";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("account","qiyei2009");
        LogUtils.println(TAG,"servletContext,account:" + servletContext.getAttribute("account"));
    }
}
