<%--
  Created by IntelliJ IDEA.
  User: daner
  Date: 2019/10/6
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AjaxDemo js调用ajax</title>
    <style type="text/css">
        input{
            width:250px;
            height: 25px;
        }
        #login{
            width: 255px;
            height: 35px;
            background-color: #FF2611;
            border: 0px;
            cursor: pointer;
            color: white;
        }
        .c1{
            font-size:24px;
            color:black;
            font-weight:bolder
        }
        .c2{
            font-size:14px;
            color:#666;
        }
        .c3{
            font-size:14px;
            color:red;
        }
    </style>


</head>
<body style="text-align: center">
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath() + "/";
    %>

    <input type="button" value="查看java课程" flag = "1" onclick="showJava()">
    <input type="button" value="查看C课程" flag = "2" onclick="showC()">
    <div style="width: 400px;height:300px" id="div1">
    </div>
</body>

<!--js调用ajax-->
<script type="text/javascript">
    function showJava() {
        //1 创建XMLHttpRequest对象
        let xmlHttp = new XMLHttpRequest();
        //2 规定请求的类型、URL 以及是否异步处理请求
        xmlHttp.open("GET","<%=basePath%>AjaxListCourseServlet?flag=1",true);
        //3 将请求发送到服务端
        xmlHttp.send();
        //4 接受服务端的响应(readyState=4表示请求已完成且响应已就绪    status=200表示请求响应一切正常)
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                //responseText:表示服务器返回给Ajax数据
                document.getElementById("div1").innerHTML = xmlHttp.responseText;
                //alert(xmlhttp.responseText);
            }
        }
    }

    function showC() {
        //1 创建XMLHttpRequest对象
        let xmlHttp = new XMLHttpRequest();
        //2 规定请求的类型、URL 以及是否异步处理请求
        xmlHttp.open("POST","<%=basePath%>AjaxListCourseServlet",true);
        //3 设置请求头
        xmlHttp.setRequestHeader("Content-Type"
            , "application/x-www-form-urlencoded");
        //4 将请求发送到服务端
        xmlHttp.send("flag=" + 2);
        //5 接受服务端的响应(readyState=4表示请求已完成且响应已就绪    status=200表示请求响应一切正常)
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                //responseText:表示服务器返回给Ajax数据
                document.getElementById("div1").innerHTML = xmlHttp.responseText;
                //alert(xmlhttp.responseText);
            }
        }
    }
</script>

</html>
