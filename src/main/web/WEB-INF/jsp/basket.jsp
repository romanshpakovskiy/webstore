<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>basket</title>

    <link href="${pageContext.request.contextPath}/js/countRegulation.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>

<div class="basket-section">
    <div class="row">
        <h1 class="basket-content">Basket(${} items)</h1>
        <c:forEach items="${requestScope.}">
            <div class="product-section">
                <div class="prod-img">
                    <img src="#">
                </div>
                <div>

                </div>
                <input type="button" value="+" onClick="change('amount',0,10, 1);"/>
                <input id="amount" type="text" value="1"/>
                <input type="button" value="-" onClick="change('amount',0,10,-1);"/>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
