package com.qiyei.listener; /**
 * @author Created by qiyei2015 on 2019/10/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */

import com.qiyei.utils.DBUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootStrapListener implements ServletContextListener{


    // Public constructor is required by servlet spec
    public BootStrapListener() {

    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器加载中...");
        DBUtils.init();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DBUtils.close();
        System.out.println("容器销毁中...");
    }

}
