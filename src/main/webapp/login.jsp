<%--
  Created by IntelliJ IDEA.
  User: astrie
  Date: 2/22/24
  Time: 3:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="description" content="Login - Register Template">
    <meta name="author" content="Lorenzo Angelino aka MrLolok">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="main.css">
    <style>
        body {
            background-color: #303641;
        }
    </style>
</head>

<body>
<div id="container-login">
    <div id="title">
        <i class="material-icons lock">lock</i> Login
    </div>

    <form action="login" method="post">
        <div class="input">
            <div class="input-addon">
                <i class="material-icons">face</i>
            </div>
            <input id="username" placeholder="email" name="email" type="email" required class="validate" autocomplete="off">
        </div>

        <div class="clearfix"></div>

        <div class="input">
            <div class="input-addon">
                <i class="material-icons">vpn_key</i>
            </div>
            <input id="password" placeholder="Password" type="password" name="password" required class="validate" autocomplete="off">
        </div>

        <div class="remember-me">
            <input type="checkbox">
            <span style="color: #DDD">Remember Me</span>
        </div>

        <input type="submit" value="Log In" />
    </form>

    <div class="forgot-password">
        <a href="#">Forgot your password?</a>
    </div>
    <div class="privacy">
        <a href="#">Privacy Policy</a>
    </div>

    <div class="register">
        Don't have an account yet?
        <a href="index.jsp"><button id="register-link">Register here</button></a>
    </div>
</div>
</body>

</html>
