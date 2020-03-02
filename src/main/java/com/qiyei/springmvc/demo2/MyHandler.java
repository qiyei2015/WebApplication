package com.qiyei.springmvc.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Created by qiyei2015 on 2020/3/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@Controller
public class MyHandler {

    @RequestMapping("/test1")
    public ModelAndView test1(){
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("name","jey");
        //添加视图
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     * 构造ModelAndView，返回view视图名
     * @param model
     * @return
     */
    @RequestMapping("/test2")
    public String test2(Model model){
        model.addAttribute("name","haha");
        return "show";
    }

    @RequestMapping("/test3")
    public String test3(Map<String,String> map){
        map.put("name","cat");
        return "show";
    }
}
