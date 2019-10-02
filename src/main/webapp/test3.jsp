<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/9/15
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP包导入语法</title>
</head>
<body>
<%@ page import="java.io.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.*,java.time.*" %>

<% out.println(new Date().getTime());%>

</body>
</html>
