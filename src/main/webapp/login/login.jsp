<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/4
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="./../css/login.css">
</head>
<body>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
    System.out.println("basePath:" + basePath);
%>
    <div class="login">
        <div class="header">
            <h1>
                <!--a是超链接标签-->
                <a href="./login.jsp">登录</a> <a href="register.jsp">注册</a>
            </h1>
        </div>
        <form action="<%=basePath%>LoginServlet" method="post">
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
                    <!--colspan="2 表示横跨2列-->
                    <td class="td1" colspan="2"><input type="checkbox" name="remember" value="true" checked="checked">记住用户名</td>
                </tr>
                <tr>
                    <!--colspan="2 表示横跨2列-->
                    <td colspan="2">
                        <div class="btn-red">
                            <input type="submit" value="登录" id="login-btn">
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
