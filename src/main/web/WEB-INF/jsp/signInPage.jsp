<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="${pageContext.request.contextPath}/styles/regsignstyles.css" rel="stylesheet" type="text/css">
    <title>Authorization</title>
</head>
<body>
<form class="form-signin" method="get" action="controller">
    <input name="command" type="hidden" value="sign_in"/>
    <h1 style="text-align: center; font-family: 'Segoe UI', sans-serif;">Please sign in</h1>
    <label for="email"></label>
    <input type="email" placeholder="Email address" id="email" name="email" class="form-control" required autofocus>
    <label for="password"></label>
    <input type="password" placeholder="Password" id="password" name="password" class="form-control" required autofocus>
    <button class="sign-in-button" type="submit">Sign in</button>
</form>
<hr>
<form class="register-btn" action="${pageContext.request.contextPath}/registration">
    <button class="register-button" type="submit">Register</button>
</form>
</body>
</html>