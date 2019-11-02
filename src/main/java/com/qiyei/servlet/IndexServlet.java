package com.qiyei.servlet;

import com.qiyei.common.CommonConstant;
import com.qiyei.domain.bean.User;
import com.qiyei.domain.dao.UserDao;
import com.qiyei.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2019/11/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

    private static final String TAG = "IndexServlet";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从ServletContext域中获得保存用户信息集合
        List<User> list = new UserDao().queryAll();
        LogUtils.println(TAG,"doGet list:" + list.size());
        request.setAttribute("userList",list);
        LogUtils.println(TAG,"doGet session:" + request.getSession().getAttribute(CommonConstant.KEY_USER));
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
