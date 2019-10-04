<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/2
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--
    pageContext
    1 请求转发 forward
    2 include方法 包含关系
    3 可以获取其他对象的信息
-->
<%
    pageContext.include("header.jsp");
    //pageContext.forward("a.jsp?name=qiyei2009");
    out.println(this.getServletInfo());
%>

</body>
</html>
