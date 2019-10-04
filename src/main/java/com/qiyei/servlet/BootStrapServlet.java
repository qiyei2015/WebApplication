package com.qiyei.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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



}
