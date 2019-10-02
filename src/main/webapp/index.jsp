<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<%! String he = "out";%>

<%!
    public String getHello(){
        return "你是SB";
    }

%>

<%
    out.println(getHello());
%>

</body>
</html>
