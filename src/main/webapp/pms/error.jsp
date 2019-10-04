<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/2
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<!--
1 exception只能在错误页面使用 isErrorPage="true"
2 其他页面出现错误，可以指定错误页面 errorPage="error.jsp"
-->
<%=exception.getMessage()%>
</body>
</html>
