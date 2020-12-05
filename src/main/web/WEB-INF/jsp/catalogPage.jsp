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
    <title>catalog</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="header">
    <%--    <a href="index.jsp" style="font-family:Bahnschrift sans-serif; padding-left: 5px; width: 105%;--%>
    <%--text-de">storesname.com</a>--%>
    <h1 style="font-family: 'Berlin Sans FB',sans-serif;font-weight: lighter; padding-right: 50%">choose from the
        best</h1>
    <form class="sign-in" action="<c:url value="/signIn"/>">
        <button class="sign-in-btn" type="submit">Log In</button>
    </form>
</div>

<div class="navbar">
    <div class="subnav">
        <form action="${pageContext.request.contextPath}/catalog">
            <button class="subnavcatalog">Catalog</button>
        </form>
    </div>

    <div class="search-container">
        <form method="get">
            <label><input type="text" placeholder="Search.." name="search"></label>
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
    </div>
</div>

<div class="catalog-nav">
    <c:forEach items="${applicationScope.categories}" var="category">
        <a href="controller?command=get_categories&category_id=${category.id}">${category.name}</a>
    </c:forEach>
</div>

<div class="catalog-wrapper">
    <div class="product-wrapper">
        <c:forEach items="${requestScope.sorted_products}" var="product">
            <form action="controller" method="get">
                <input type="hidden" name="command" value="get_product"/>
                <input type="hidden" name="product_id" value="${product.id}">
                <div class="product-name">${product.name}</div>
                <div class="prod-img">
                    <img src="#">
                </div>
                <div class="product-price">${product.price}</div>
                <button class="view-prod-btn">View</button>
            </form>

            <form action="controller" method="post">

                <button class="add-to-basket-btn">Add to basket</button>
            </form>
        </c:forEach>
    </div>
</div>

<div class="catalog-wrapper">
    <div class="product-wrapper">
        <c:forEach items="${requestScope.products}" var="product">
            <div class="product">
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="get_product"/>
                    <input type="hidden" name="product_id" value="${product.id}">
                    <div class="product-name">${product.name}</div>
                    <div class="prod-img">
                        <img src="#">
                    </div>
                    <div class="product-price">${product.price}</div>
                    <button class="view-prod-btn">View</button>
                </form>

                <form action="controller" method="post">
                    <input type="hidden" name="command" value="add_products_in_basket">
                        <label>
                            <input type="number" name="count" step="1" min="1" max="10" value="1" pattern="[0-9]*">
                        </label>
                    <input type="hidden" name="product_id" value="${requestScope.product.id}">
                    <button class="add-to-basket-btn">Add to basket</button>
                </form>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>