<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户管理中心</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="lib/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>后台管理系统 <small>用户数据管理中心</small></h1>
        </div>
    </div>

    <div class="row">
        <div class="jumbotron">
            <h1>MyBatis基础入门课程</h1>
            <p>通过一个项目来完成基础部分的学习</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">查看更多</a> </p>
            <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/login/register.jsp" role="button">注册新用户</a> </p>
        </div>
    </div>

    <div class="row">
        <table class="table table-hover table-striped">
            <tr>
                <th>用户编号</th>
                <th>登录账号</th>
                <th>用户昵称</th>
                <th>邮箱</th>
                <th>联系方式</th>
                <th>账号创建时间</th>
                <th>用户状态</th>
                <th>操作</th>
            </tr>
            <!--循环增加数据-->
            <c:forEach var="user" items="${userList}">
                <tr>
                    <th>${user.id}</th>
                    <th>${user.userName}</th>
                    <th>${user.nickname}</th>
                    <th>${user.sex}</th>
                    <th>${user.hobby}</th>
                    <th>${user.iconPath}</th>
                    <th>${user.userName}</th>
                    <th>${user.userName}</th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

