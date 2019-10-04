<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人事管理系统登录页面</title>
</head>
<body>
<%
    //重定向到登录页面 request.getContextPath()获取当前应用名
    response.sendRedirect(request.getContextPath() + "/login/login.jsp");
%>

</body>
</html>
