package com.qiyei.servlet;

import com.qiyei.common.CommonConstant;
import com.qiyei.domain.bean.User;
import com.qiyei.domain.dao.UserDao;
import com.qiyei.utils.LogUtils;
import com.qiyei.utils.TextUtils;
import com.qiyei.utils.UploadFileUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2019/10/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final String TAG = "RegisterServlet";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //数据接收
        //文件上传基本操作

        //定义map用于保存接收到的数据
        Map<String,String> map = new HashMap<>();
        //定义hobbyList用于保存爱好
        List<String> hobbyList = new ArrayList<>();
        String url = null;
        try {
            //1.创建一个磁盘文件项工厂对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //2 创建核心解析类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            //3 解析request请求，返回的是list集合
            List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
            //4 遍历集合，获得每个FileItem，判断是表单项还是文件上传项
            for (FileItem item:fileItemList){
                if (item.isFormField()){
                    //普通表单项
                    String name = item.getFieldName();
                    String value = item.getString("utf-8");
                    LogUtils.println(TAG,name +" -> " + value);
                    //接收复选框的数据
                    if ("hobby".equals(name)){
                        hobbyList.add(value);
                        String hobbyValue = hobbyList.toString().substring(1,hobbyList.toString().length() - 1);
                        map.put(name,hobbyValue);
                    }else {
                        map.put(name,value);
                    }

                }else {
                    //文件上传项
                    String fileName = item.getName();
                    if (!TextUtils.isEmpty(fileName)){
                        LogUtils.println(TAG,"uploadFile:" + fileName);
                        String uuidFileName = UploadFileUtils.getUUIDFileName(fileName);
                        LogUtils.println(TAG,"uuidFileName:" + uuidFileName);
                        //获取文件上传的数据
                        InputStream inputStream = item.getInputStream();
                        //获取文件上传路径
                        String path = getServletContext().getRealPath(CommonConstant.KEY_FILE_UPLOAD);

                        //写入到本地流中
                        url = path + "\\" + uuidFileName;
                        File file = new File(url);
                        if(!file.exists()){
                            //先得到文件的上级目录，并创建上级目录，在创建文件
                            file.getParentFile().mkdir();
                            try {
                                //创建文件
                                file.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        OutputStream outputStream = new FileOutputStream(url);
                        int len = 0;
                        byte[] buff = new byte[1024];
                        while ((len = inputStream.read(buff)) != -1){
                            outputStream.write(buff,0,len);
                        }
                        inputStream.close();
                        outputStream.close();
                    }
                }
            }

            LogUtils.println(TAG," map:" + map);

            //获取ServletContext对象，用于校验是否已经注册
            List<User> userList = (List<User>) getServletContext().getAttribute(CommonConstant.KEY_USER_LIST);
            for (User user : userList){
                if (user.getUserName().equals(map.get(CommonConstant.KEY_USERNAME))){
                    request.setAttribute(CommonConstant.KEY_MESSAGE,"用户名已经存在！");
                    request.getRequestDispatcher("/login/register.jsp").forward(request,response);
                    return;
                }
            }

            //封装数据
            User user = new User(map.get("username"),map.get("password"),map.get("nickname"),
                    map.get("sex"), map.get("hobby"),url);
            //将用户信息存储ServletContext中
            UserDao userDao = new UserDao();
            userDao.insert(user);

            userList.add(user);
            LogUtils.println(TAG,userList);
            getServletContext().setAttribute(CommonConstant.KEY_USER_LIST,userList);

            //注册成功，跳转到登录页面
            request.getSession().setAttribute(CommonConstant.KEY_USERNAME,user.getUserName());
            response.sendRedirect(request.getContextPath() + "/login/login.jsp");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

}
