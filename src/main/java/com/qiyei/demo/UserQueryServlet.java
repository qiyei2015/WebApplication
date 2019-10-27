package com.qiyei.demo;

import com.qiyei.domain.dao.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Created by qiyei2015 on 2019/10/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@WebServlet("/UserQueryServlet")
public class UserQueryServlet extends HttpServlet {

    private Logger log = Logger.getLogger(UserQueryServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDao userDao = new UserDao();
        log.info("id:" + id + " obj:" + userDao.queryUser(Integer.valueOf(id)));
    }
}
