<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/5
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入jstl并定义前缀-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>JSTLDemo</title>
</head>
<body>

<div align="center">
    <h3>set、out、remove 标签</h3>
    <!-- set、out、remove 标签 -->
    <!-- set标签主要是往指定的域中存放数据 -->
    <c:set var="user" value="哈哈哈" scope="request"></c:set>
    <!-- out标签主要用于将数据打印显示-->
    <c:out value="${user}"></c:out>
    <hr>
    <!--删除数据-->
    <c:remove var="user" scope="request"></c:remove>
    <!-- out标签主要用于将数据打印显示-->
    <c:out value="${user}"></c:out>
</div>

<div align="center">
    <h3>if choose 标签</h3>
    <!-- if choose 标签 -->
    <!-- if标签主要是逻辑判断 -->
    <c:set var="age" value="15" scope="request"></c:set>
    <c:if test="${age == 15}">
        你的年龄是${age}
    </c:if>
    <hr>
    <!--choose标签 -->
    <c:set var="name" value="张三" scope="request"></c:set>
    <c:choose>
        <c:when test="${name == '张三'}">
            姓名是${name}
        </c:when>
        <c:otherwise>
            不知道是谁
        </c:otherwise>
    </c:choose>
</div>

<div align="center">
    <hr>
    <h3>forEach 标签</h3>
    <!-- forEach 标签 主要用于循环迭代-->
    <table align="center" border="1px" width="600px">
        <tr>
            <td>商品名称</td>
            <td>产地</td>
            <td>价格</td>
        </tr>
        <c:forEach items="${list}" var="Map">
            <tr>
                <td>${Map.shopName}</td>
                <td>${Map.address}</td>
                <td>${Map.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
