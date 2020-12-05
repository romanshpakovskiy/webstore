<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css"/>
    <title>product</title>
</head>
<body>
    <jsp:include page="header.jsp"/>

    <jsp:include page="navbar.jsp"/>

    <div class="prod-wrapper">
        <div class="product-name">${requestScope.product.name}</div>
        <div class="product-price">${requestScope.product.price}</div>
    </div>

</body>
</html>
