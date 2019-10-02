<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/9/15
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人事管理系统登录页面</title>
</head>
<body>
<h3 align="center">人事管理系统登录页面</h3>
<hr>
config对象：<%=config.getServletName()%>
<br>
config参数：<%=config.getInitParameter("age")%>
<%
    request.setAttribute("name","qiyei2009");
    //进行页面请求分发
    //request.getRequestDispatcher("result.jsp").forward(request,response);
%>
<!--from是表单 action代表了服务端的处理程序 可以是jsp也可以是servert-->
<form action="control.jsp">
    <!--表格-->
    <table align="center">
        <!--表格 一行-->
        <tr>
            <!--单元格-->
            <td>
                账号：
            </td>
            <td>
                <input type="text" name="account">
            </td>
        </tr>

        <tr>
            <!--单元格-->
            <td>
                密码：
            </td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" name="login" value="登录">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
