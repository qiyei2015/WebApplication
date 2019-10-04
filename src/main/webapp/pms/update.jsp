<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/2
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人事管理系统修改页面</title>
</head>
<body>
<h3 align="right">登录账号:<%=session.getAttribute("account")%>
</h3>

<h3 align="center">人事管理系统修改页面</h3>
<hr>

<form action="update_control.jsp">
    <table align="center">
        <tr>
            <td>
                账号
            </td>
            <td>
                <input type="text" name="account" value=<%= request.getParameter("account")%> readOnly="true">
            </td>
        </tr>
        <tr>
            <td>
                姓名
            </td>
            <td>
                <input type="text" name="name" value=<%= request.getParameter("name")%>>
            </td>
        </tr>
        <tr>
            <td>
                邮箱
            </td>
            <td>
                <input type="email" name="email" value=<%= request.getParameter("email")%>>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="update" value="提交">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
