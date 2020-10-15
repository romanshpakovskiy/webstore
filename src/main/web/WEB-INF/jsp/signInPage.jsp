<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Authorization</title>
    <link href="../regsignstyles.css" rel="stylesheet" type="text/css">
</head>
<body>
<form class="form-signin">
    <h1 style="text-align: center; font-family: 'Segoe UI', sans-serif;">Please sign in</h1>
    <label for="email"></label>
    <input type="email" placeholder="Email address" id="email" class="form-control" required autofocus>
    <label for="password"></label>
    <input type="password" placeholder="Password" id="password" class="form-control" required>
    <button class="sign-in-button" type="submit">Sign in</button>
    <hr>
    <form class="register-btn" action="registrationPage.jsp">
        <button class="register-button" type="submit">Register</button>
    </form>
</form>
</body>
</html>