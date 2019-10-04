package com.qiyei.servlet;

import com.qiyei.common.CommonConstant;
import com.qiyei.domain.bean.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2019/10/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */

/**
 * 指定启动优先级为2，启动就去加载
 */
@WebServlet(name = "BootStrapServlet",value = "/BootStrapServlet",loadOnStartup = 2)
public class BootStrapServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //创建一个List集合用于保存用户注册的信息
        List<User> list = new ArrayList<>();
        //将list保存到ServletContext作用域中:
        getServletContext().setAttribute(CommonConstant.KEY_USER_LIST,list);
    }
}
