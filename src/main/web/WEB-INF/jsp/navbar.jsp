<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>catalog</title>

    <link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="navbar">
    <div class="subnav">
        <form action="controller" method="get">
            <input type="hidden" name="command" value="get_products">
            <button class="subnavcatalog">Catalog<i class="fa fa-caret-down"></i></button>
        </form>

        <div class="subnavcatalog-content">
            <c:forEach items="${applicationScope.categories}" var="category">
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="get_products_by_category">
                    <input type="hidden" name="category_id" value="${category.id}">
                    <button class="subnavcatalog-content-button">${category.name}</button>
                </form>
            </c:forEach>
        </div>
    </div>

    <div class="search-container">
        <form method="get">
            <label><input type="text" placeholder="Search.." name="search"></label>
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
    </div>
</div>
</body>
</html>
