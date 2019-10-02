<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/9/14
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP声明语法和脚本语法</title>
</head>
<body>
<h1>JSP声明语法和脚本语法</h1>
<p>
    这是一个测试用例
</p>

<% int i = 10;%>
<%! int j = 10;%>
<%! String aa = "hahh";%>
<%
    if (i > 10) {
        out.println("i 大于10");
    } else {
        out.println("i 小于10");
        i++;
        j++;
        aa = "bb";
    }
    %>
<br>
<%--这是一个jsp注释 --%>
<%
    out.println(aa);
    out.println(i);
%>
<br>
<%
    //java注释
    out.println(j);
%>

</body>
</html>
