<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="css/main.css"/>
</head>
<body style="background: #FF416C; background: -webkit-linear-gradient(to right, #FF4B2B, #FF416C); background: linear-gradient(to right, #FF4B2B, #FF416C);">
 <h1 style="color: #f6f5f7;" class="large">Hello, ${username}!</h1>
 <hr>
 <h1 style="color: #383838">${message}</h1>
 <br>
 <button class="ghost" onclick="window.location.href='/'">Logout</button>
</body>
</html>