<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>main page</title>
    <link href="styles.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="header">
    <h1 style="font-family: Bahnschrift sans-serif;padding-left: 5px; width: 105%">storesname.com
        <span style="font-family: 'Berlin Sans FB',sans-serif;
        font-weight: lighter; padding-left: 50%">choose from the best</span>
    </h1>
    <form class="sign-in" action="jsp/signInPage.jsp">
        <button class="sign-in-btn" type="submit">Log In</button>
    </form>
</div>

<div class="navbar">
    <div class="subnav">
        <button class="subnavcatalog">Catalog<i class="fa fa-caret-down"></i></button>
        <div class="subnavcatalog-content">
            <c:forEach items="${requestScope.categories}" var="category">
                <a href="controller?command=get_products&category_id=">${category.name}</a>
            </c:forEach>
        </div>
    </div>
    <div class="search-folder">
        <form method="get">
            <label>
                <input type="text" placeholder="Search..">
            </label>
            <button type="submit">search</button>
        </form>
    </div>
    <!--    <a href="zdesbudetbasketpotom.jsp"><img src="images/icon25.png" alt="Button"></a>-->
</div>
</body>
</html>
