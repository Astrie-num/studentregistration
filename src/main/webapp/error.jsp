<%--
  Created by IntelliJ IDEA.
  User: astrie
  Date: 2/22/24
  Time: 4:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<%
    String error = (String) request.getAttribute("error");
%>
    <h1><%=error%></h1>

</body>
</html>
