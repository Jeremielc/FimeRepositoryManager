<%@ page import="sample.HelloWorld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Simple jsp page</title>
</head>
<body>
<h3 class="message"><%=HelloWorld.getMessage()%></h3>
<%
    out.println("<p>Your IP address is : " + request.getRemoteAddr() + "</p>");
    out.println("<p>The current path is : " + System.getProperty("user.dir") + "</p>");
%>
</body>
</html>
