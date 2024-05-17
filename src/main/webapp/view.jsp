<%--
  Created by IntelliJ IDEA.
  User: astrie
  Date: 2/22/24
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="description" content="Dashboard">
    <meta name="author" content="Lorenzo Angelino aka MrLolok">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<%--    <link rel="stylesheet" href="main.css">--%>
    <style>
        body {
            background-color: #303641;
            display: flex;
            align-content: center;
            justify-content: center;
            flex-direction: column;
            /*font-size: 1.5em;*/
        }
        .container{
            display: flex;
            align-content: center;
            justify-content: center;
            font-size: 1.5em;
            /*font-family: cursive;*/
            height: 20%;
            width: 100%;
            color:beige;
        }
        .container2{
            display: flex;
            align-content: center;
            justify-content: center;
            flex-direction: row;
            font-size: 1.5em;
            height: 50%;
            width: 100%;


        }
        .container3{
            display: flex;
            align-content: center;
            justify-content: center;
            height: 30%;
            width: 100%;

            /*flex-direction: column;*/
            /*font-size: 0.5em;*/
        }

        .button-one{
            padding: 2rem;
            width: 400px;
            height: 200px;
            font-size: 2em;
            margin-right: 10px;
            border-radius: 8px;



        }
        .button-two{
            padding: 2rem;
            width: 400px;
            height: 200px;
            font-size: 2em;
            margin-left: 10px;
            border-radius: 8px;



        }
        .button-three{
            padding: 2rem;
            width: 200px;
            height: 100px;
            font-size: 2em;
            /*margin-left: 10px;*/
            background-color:indianred;
            border-radius: 8px;
            box-shadow: none;


        }
        a{
            text-decoration: none;
            color:white;
        }

    </style>
</head>
    <body>
    <div class="container">
        <h1>Choose what to review</h1>
    </div>

    <div class="container2">
<%--        <div class = "input-one">--%>
            <form action="displayData">
                <button type="submit" class="button-one">view subjects</button>
            </form>
<%--        </div>--%>

<%--        <div class="input-two">--%>
                <form action="displayStudents">
                    <button type="submit" class="button-two">view students</button>
                </form>
<%--            </div>--%>


    </div>

<div class="container3">
    <button class="button-three"><a href="logout">logout</a></button>
<%--    <a href="logout">logout</a>--%>
</div>

    </body>
    </html>


