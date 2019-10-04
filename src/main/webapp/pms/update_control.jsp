<%@ page import="com.qiyei.pms.bean.Emp" %>
<%@ page import="com.qiyei.pms.db.DBUtil" %><%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/2
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String account = request.getParameter("account");
    Emp emp = DBUtil.getUserMap().get(account);
    out.println(account);
    emp.setName(request.getParameter("name"));
    emp.setEmail(request.getParameter("email"));
%>

<h3 align="center">修改员工信息成功</h3>

</body>
</html>
