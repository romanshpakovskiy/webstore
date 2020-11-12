<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
    <link href="${pageContext.request.contextPath}/styles/regsignstyles.css" rel="stylesheet" type="text/css">


</head>
<body>
<form class="form-registration" method="post" action="controller">
    <input name="command" type="hidden" value="registration"/>
    <h1 style="text-align: center; font-family: 'Segoe UI', sans-serif;">Register please</h1>
    <label for="name"><b></b></label>
    <input type="text" placeholder="Name" id="name" name="name" class="form-control" required autofocus>
    <label for="surname"></label>
    <input type="text" placeholder="Surname" id="surname" name="surname" class="form-control" required autofocus>
    <label for="email"></label>
    <input type="email" placeholder="Email address" id="email" name="email" class="form-control"
           pattern="[[a-z0-9]+@(?!-)[A-Za-z0-9-]{1,63}!-)\\.)]+[A-Za-z]{2,6}$" aria-live="polite" required autofocus>
    <label for="password"></label>
    <input type="password" placeholder="Password" id="password" name="password" class="form-control" required autofocus>
    <label for="address"></label>
    <input type="text" placeholder="Address" id="address" name="address" class="form-control" required autofocus>
    <button class="register-button" type="submit">Register</button>
</form>
<hr>
<form action="${pageContext.request.contextPath}/signIn">
    <button class="sign-in-button" type="submit">SignIn</button>
</form>
</body>
</html>