<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>STUDENT MANAGEMENT"</title>
  <meta name="description" content="Login - Register">
  <meta name="author" content="Lorenzo Angelino aka MrLolok">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="main.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <style>
    body {
      background-color: #303641;
    }
  </style>
</head>

<body>
<div id="container-register">
  <div id="title">
    <i class="material-icons lock">lock</i> Register
  </div>

  <form action="register" method="post">
    <div class="input">
      <div class="input-addon">
        <i class="material-icons">face</i>
      </div>
      <input id="lastname" placeholder="last name" type="text" name="last_name" required class="validate" autocomplete="off">
    </div>

    <div class="clearfix"></div>

    <div class="input">
      <div class="input-addon">
        <i class="material-icons">face</i>
      </div>
      <input id="firstname" placeholder="first name" type="text" name = "first_name" required class="validate" autocomplete="off">
    </div>

    <div class="clearfix"></div>

    <div class="input">
      <div class="input-addon">
        <i class="material-icons">email</i>
      </div>
      <input id="email" placeholder="email" type="email" name="email" required class="validate" autocomplete="off">
    </div>

    <div class="clearfix"></div>

    <div class="input">
      <div class="input-addon">
        <i class="material-icons">vpn_key</i>
      </div>
      <input id="age" placeholder="age" type="number" name="age" required class="validate" autocomplete="off">
    </div>

    <div class="clearfix"></div>

    <div class="input">
      <div class="input-addon">
        <i class="material-icons">vpn_key</i>
      </div>
      <input id="username" placeholder="username" type="text" name="username" required class="validate" autocomplete="off">
    </div>

    <div class="clearfix"></div>

    <div class="input">
      <div class="input-addon">
        <i class="material-icons">vpn_key</i>
      </div>
      <input id="password" placeholder="password" type="password" name="password" required class="validate" autocomplete="off">
    </div>

    <div class="remember-me">
      <input type="checkbox">
      <span style="color: #DDD">I accept Terms of Service</span>
    </div>

    <input type="submit" value="Register" />
  </form>

  <div class="privacy">
    <a href="#">Privacy Policy</a>
  </div>

  <div class="register">
    Do you already have an account?
    <a href="./login.jsp"><button id="register-link">Log In here</button></a>
  </div>
</div>
</body>

</html>
