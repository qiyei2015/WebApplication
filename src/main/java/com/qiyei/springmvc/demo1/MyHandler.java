package com.qiyei.springmvc.demo1;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Created by qiyei2015 on 2020/3/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class MyHandler implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("name","tom");
        //添加视图
        modelAndView.setViewName("show");

        return modelAndView;
    }


}
