package com.qiyei.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author Created by qiyei2015 on 2019/10/13.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@WebFilter(filterName = "CharacterEncodingFilter",urlPatterns = "/*",
        initParams = {@WebInitParam(name = "charset",value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {
    private FilterConfig mConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String charset = mConfig.getInitParameter("charset");
        req.setCharacterEncoding(charset);
        //测试过滤器（链）工作流程使用
        System.out.println("characterEncodingFilter doFilter,charset:" + charset);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        mConfig = config;
    }

}
