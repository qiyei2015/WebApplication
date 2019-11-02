<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/4
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.qiyei.utils.CookieUtils" %>
<%@ page import="com.qiyei.common.CommonConstant" %>
<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
    System.out.println("basePath:" + basePath);
%>
<head>
    <title>用户管理中心登录页面</title>
    <!--此处css路径需配置层绝对路径，要不然首次启动找不到-->
    <link rel="stylesheet" href="<%=basePath%>lib/css/login.css">
    <script type="text/javascript" src="<%=basePath%>lib/js/jquery-1.4.2.js"></script>
</head>
<body>
<%
    String userName = "";
    //获取cookies
    Cookie[] cookies = request.getCookies();
    Cookie cookie = CookieUtils.findCookie(cookies, CommonConstant.KEY_USERNAME);
    if (cookie != null){
        userName = cookie.getValue();
    }

    if (session.getAttribute(CommonConstant.KEY_USERNAME) != null){
        userName = (String) session.getAttribute(CommonConstant.KEY_USERNAME);
    }

    String msg = "";
    if (request.getAttribute(CommonConstant.KEY_MESSAGE) != null){
        msg = (String) request.getAttribute(CommonConstant.KEY_MESSAGE);
    }
%>
<div class="login">
    <div class="header">
        <h1>
            <!--a是超链接标签-->
            <a href="./login.jsp">登录</a> <a href="register.jsp">注册</a>
        </h1>
    </div>
    <h3><span style="color: red; "><%=msg %></span></h3>
    <span class="tip" style="color:red;font-size:16px"></span>
    <form>
        <table>
            <tr>
                <td class="td1">用户名</td>
                <td><input type="text" class="input1" name="username" value="<%=userName%>"></td>
            </tr>
            <tr>
                <td class="td1">密码</td>
                <td><input type="password" class="input1" name="password"></td>
            </tr>
            <tr>
                <!--colspan="2 表示横跨2列-->
                <td class="td1" colspan="2"><input type="checkbox" name="remember" value="true" checked="checked">记住用户名
                </td>
            </tr>
            <tr>
                <!--colspan="2 表示横跨2列-->
                <td colspan="2">
                    <div class="btn-red">
                        <input type="button" value="登录" id="login-btn">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>

<script>
    <!--使用id-->
    $("#login-btn").click(function () {
        //单击登录按钮的时候出发ajax事件
        $.ajax({
            url:"<%=basePath%>LoginServlet",
            type:"post",
            data:{
                username:$("input[name=username]").val(),
                password:$("input[name=password]").val()
            },
            dataType:"json",
            success:function (result) {
                let flag = result.flag;
                if (flag == true){
                    //成功则跳转成功页面
                    window.location.href = "<%=basePath%>login/success.jsp"
                } else {
                    //失败则提示
                    $(".tip").text("你输入的用户名密码不正确");
                }
            }
        });
    });
</script>

</html>
