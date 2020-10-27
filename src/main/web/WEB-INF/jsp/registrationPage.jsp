<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
    <style><%@include file="../regsignstyles.css"%></style>
</head>
<body>
<form class="form-registration">
    <h1 style="text-align: center; font-family: 'Segoe UI', sans-serif;">Register please</h1>
    <label for="name"></label>
    <input type="text" placeholder="Name" id="name" name="name" class="form-control" required autofocus>
    <label for="surname"></label>
    <input type="text" placeholder="Surname" id="surname" name="surname" class="form-control" required autofocus>
    <label for="email"></label>
    <input type="email" placeholder="Email address" id="email" name="email" class="form-control" required autofocus>
    <label for="password"></label>
    <input type="password" placeholder="Password" id="password" name="password" class="form-control" required autofocus>
    <label for="repassword"></label>
    <input type="password" placeholder="Re-entered password" id="repassword" name="repassword" class="form-control" required autofocus>
    <hr>
    <button class="register-button" type="submit">Register</button>
</form>
</body>
</html>