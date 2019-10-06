package com.qiyei.servlet;

import com.qiyei.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Created by qiyei2015 on 2019/10/6.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@WebServlet("/AjaxListCourseServlet")
public class AjaxListCourseServlet extends HttpServlet {

    private static final String TAG = "AjaxListCourseServlet";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        String data = "";
        LogUtils.println(TAG,"flag:" + flag);
        if (flag.equals("1")){
            data = "Java从入门到精通<br>java框架";
        }else {
            data = "C程序设计<br>C项目实战";
        }
        response.getOutputStream().write(data.getBytes("utf-8"));
    }
}
