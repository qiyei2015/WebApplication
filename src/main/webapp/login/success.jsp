<%@ page import="com.qiyei.common.CommonConstant" %>
<%@ page import="com.qiyei.domain.bean.User" %>
<%@ page import="java.util.Timer" %>
<%@ page import="java.util.TimerTask" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/4
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
    <link rel="stylesheet" href="../lib/css/login.css">
</head>
<body>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
    if (session.getAttribute(CommonConstant.KEY_USER ) != null){
      User user = (User) session.getAttribute(CommonConstant.KEY_USER);
      //获得绝对路径最后一个\的位置
      int index = user.getIconPath().lastIndexOf("\\");
      String fileName = user.getIconPath().substring(index+1);
      String imvPath = request.getContextPath() + "/" + CommonConstant.KEY_FILE_UPLOAD  + "/" + fileName;
%>
    <div class="login">
        <div class="header">
            <h1>登录成功</h1>
        </div>
        <div class="content">
            <table align="center">
                <tr>
                    <td align="center"><img class="profile_picture" src="<%=imvPath%>"/></td>
                </tr>
                <tr>
                    <td align="center">欢迎<%=user.getNickName()%>,登录成功!</td>
                </tr>
            </table>
        </div>
    </div>
    <script>
        let i=2;
        let time=setInterval(function(){
            if(i==0){
                //成功则跳转成功页面
                window.location.href = "<%=basePath%>IndexServlet"
            }
            i--;
        },1000)
    </script>
    <%
    } else {
    %>
        <div class="login">
            <div class="header">
                <h1>您还没有登录！请先去<a href="<%=request.getContextPath()+"/login/login.jsp"%>">登录</a>！</h1>
            </div>
        </div>
    <%
    }
    %>
</body>
</html>
