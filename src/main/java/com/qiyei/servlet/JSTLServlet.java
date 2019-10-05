package com.qiyei.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2019/10/5.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@WebServlet("/JSTLServlet")
public class JSTLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> map1 = new HashMap<>();
        map1.put("shopName", "联想笔记本");
        map1.put("address", "北京");
        map1.put("price", 4999.99);
        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("shopName", "神州笔记本");
        map2.put("address", "南京");
        map2.put("price", 3999.99);

        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        request.setAttribute("list",list);
        request.getRequestDispatcher("/demo/JSTLDemo.jsp").forward(request,response);

    }
}
