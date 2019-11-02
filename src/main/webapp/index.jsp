<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户管理中心</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="lib/css/index.css">
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
        <table class="table table-hover table-striped table2">
            <tr>
                <th>用户编号</th>
                <th>登录账号</th>
                <th>用户昵称</th>
                <th>性别</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>账号创建时间</th>
                <th>账号更新时间</th>
                <th>账号最后登录时间</th>
                <th>用户状态</th>
                <th>备注</th>
                <th>爱好</th>
                <th>头像路径</th>
                <%--                <th>操作</th>--%>
            </tr>
            <!--循环增加数据-->
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.nickName}</td>
                    <td>${user.gender}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td>
                       ${user.createTime}
                    </td>
                    <td>
                        ${user.updateTime}
                    </td>
                    <td>
                        ${user.lastLogin}
                    </td>
                    <c:choose>
                        <c:when test="${user.userStatus == 0}">
                            <td>锁定</td>
                        </c:when>
                        <c:when test="${user.userStatus == 1}">
                            <td>正常</td>
                        </c:when>
                        <c:when test="${user.userStatus == 2}">
                            <td>删除</td>
                        </c:when>
                        <c:otherwise>
                            <td>锁定</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${user.remark}</td>
                    <td>${user.hobby}</td>
                    <td>${user.iconPath}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

