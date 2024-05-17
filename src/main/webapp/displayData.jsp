
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>Display Data</title>
    <style>
        body {
            background-color: #303641;
        }
    </style>
</head>
<body>
<h2>Subjects:</h2>
<%
    ResultSet resultSet = (ResultSet) request.getAttribute("resultSet");

    if (resultSet != null) {
        while (resultSet.next()) {
            String lastName = resultSet.getString("last_name");
            String firstName = resultSet.getString("first_name");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
%>
<p>Last Name: <%= lastName %></p>
<p>First Name: <%= firstName %></p>
<p>Email: <%= email %></p>
<p>Age: <%= age %></p>
<%
        }
        resultSet.close();
    } else {
        out.println("No data available.");
    }
%>
</body>
</html>

