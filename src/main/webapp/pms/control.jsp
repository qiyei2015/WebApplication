<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/9/15
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ page import="com.qiyei.pms.bean.Emp" %>
<%@ page import="com.qiyei.pms.db.DBUtil" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>登录页面处理程序</title>
</head>
<body>
<!--1 获取用户名密码-->

<!--2 调用DBUtil中的方法进行用户名密码判断-->

<!--3 成功显示成功页面，否则显示错误页面-->
<!--
    request对象的getParameter(String key),可以通过控件的name属性获取对应的值
-->
<!-- 此时的request对象和login.jsp不是同一个，所以数据是null-->
<h3 align="center">从request的数据<%= request.getAttribute("name")%></h3>
<%
    //1        account是控件的name
    String account = request.getParameter("account");
    String password = request.getParameter("password");
    System.out.println("account:" + account + ",password:" + password);

    Emp emp = new Emp(account,null,password,null);
    //2
    boolean loginSuccess = DBUtil.verifyAccountAndPassword(emp);
    //3
    if (loginSuccess){
        session.setAttribute("account",account);
        //设置有效周期
        session.setMaxInactiveInterval(1000*60*60);

        Object o = application.getAttribute("count");
        if (o == null){
            application.setAttribute("count",1);
        }else {
            int c = Integer.parseInt(o.toString());
            application.setAttribute("count",c+1);
        }

%>
    <h3 align="right">访问量:<%=application.getAttribute("count")%></h3>
    <h3 align="right">登录账号:<%=session.getAttribute("account")%></h3>
    <h3 align="center">欢迎来到人事管理系统首页</h3>
    <h3 align="center">响应字符编码集:<%=response.getCharacterEncoding()%></h3>
    <br>
    <table align="center" border="1" width="600px">
        <tr>
            <td>
                账号
            </td>
            <td>
                姓名
            </td>
            <td>
                邮箱
            </td>
        </tr>
        <%
            Map<String,Emp> userMap = DBUtil.getUserMap();
            for (Map.Entry<String,Emp> entry:userMap.entrySet()){
                Emp item = entry.getValue();
        %>
            <tr>
                <td>
                    <%= item.getAccount()%>
                </td>
                <td>
                    <%= item.getName()%>
                </td>
                <td>
                    <%= item.getEmail()%>
                </td>
                <td>
                    <!--在相邻的jsp页面通过url传递参数-->
                    <a href="update.jsp?account=<%=item.getAccount()%>&name=<%=item.getName()%>&email=<%=item.getEmail()%>">修改</a>
                </td>
            </tr>
        <%
            }
        %>
    </table>
<%
    }else {
        throw new Exception("登录失败，用户名密码错误");
    }
%>
</body>
</html>
