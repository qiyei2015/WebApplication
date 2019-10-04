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
 */
@WebServlet(value = "/Demo2Servlet")
public class Demo2Servlet extends HttpServlet {

    private static final String TAG = "Demo2Servlet";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        LogUtils.println(TAG,"servletContext,account:" + servletContext.getAttribute("account"));
    }
}
