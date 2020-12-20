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
<jsp:include page="header.jsp"/>

<div class="navbar">
    <div class="subnav">
        <form action="${pageContext.request.contextPath}/catalog">
            <button class="subnavcatalog">Catalog</button>
        </form>

        <c:if test="${sessionScope.user!=null}">
            <form action="controller" method="get">
                <input type="hidden" name="command" value="go_to_basket">
                <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                <button class="subnavcart">Cart</button>
            </form>
        </c:if>
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
        <form action="controller" method="get">
            <input type="hidden" name="command" value="get_products_by_category">
            <input type="hidden" name="category_id" value="${category.id}">
            <button type="button" class="subnavcatalog-content-button">${category.name}</button>
        </form>
    </c:forEach>
</div>

<div class="catalog-wrapper">

    <div class="product-wrapper">
        <c:forEach items="${requestScope.products}" var="product">
            <div class="product">
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="add_products_in_basket">
                    <input type="hidden" name="product_id" value="${product.id}">
                    <label>
                        <input type="number" name="count" step="1" min="1" max="10"
                               value="1" pattern="[0-9]*">
                    </label>
                    <button class="add-to-basket-btn">Add to basket</button>
                </form>

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
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>