<%@ page import="com.qiyei.common.CommonConstant" %><%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/4
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="./../css/reg.css">
</head>
<body>
<div class="reg">
    <div class="header">
        <h1>
            <a href="./login.jsp">登录</a> <a href="register.jsp">注册</a>
        </h1>
    </div>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath() + "/";
        System.out.println("basePath:" + basePath);

        String msg = "";
        if(request.getAttribute(CommonConstant.KEY_MESSAGE)!=null){
            msg = (String)request.getAttribute(CommonConstant.KEY_MESSAGE);
        }
    %>
    <!--
    文件上传的条件
    * 表单必须是post提交方式
    * 表单中必须有文件上传项，文件上传项必须有name属性和值
    * 表单的enctype属性必须设置为multipart/form-data
 -->
    <h3><span style="color: red; "><%= msg %></span></h3>
    <form action="<%=basePath%>RegisterServlet" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td class="td1">用户名</td>
                <td><input type="text" class="input1" name="username"></td>
            </tr>
            <tr>
                <td class="td1">密码</td>
                <td><input type="password" class="input1" name="password"></td>
            </tr>
            <tr>
                <td class="td1">昵称</td>
                <td><input type="text" class="input1" name="nickname"></td>
            </tr>
            <tr>
                <td class="td1">性别</td>
                <td>
                    <input type="radio" name="sex" value="male">男
                    <input type="radio" name="sex" value="female">女
                </td>
            </tr>
            <tr>
                <td class="td1">上传头像</td>
                <td><input type="file" id="photo" name="upload"></td>
            </tr>
            <tr>
                <td class="td1">兴趣爱好</td>
                <td><label>
                    <input type="checkbox" name="hobby" value="篮球">篮球
                    <input type="checkbox" name="hobby" value="足球">足球
                    <input type="checkbox" name="hobby" value="排球">排球
                    <input type="checkbox" name="hobby" value="羽毛球">羽毛球
                </label></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="btn-red">
                        <input type="submit" value="注册" id="reg-btn">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
