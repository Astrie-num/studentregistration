<%--
  Created by IntelliJ IDEA.
  User: astrie
  Date: 2/22/24
  Time: 6:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Subject</title>
    <style>
        body {
            background-color: #303641;
        }
    </style>
</head>
<body>
<h1>Delete</h1>

<form action="deleteData" method="post">
    <label for="subject_id">Subject ID:</label><br>
    <input type="number" id="subject_id" name="subject_id"><br><br>
    <label for="subject_name">Subject Name:</label><br>
    <input type="text" id="subject_name" name="subject_name"><br><br>

    <input type="submit" value="delete subject">
</form>
</body>
</html>
