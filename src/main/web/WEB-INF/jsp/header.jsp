<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header">
    <a href="catalogPage.jsp" class="logo">ChashStore</a>

    <h1 style="font-family: 'Berlin Sans FB',sans-serif;font-weight: lighter; padding-right: 50%">choose from the best</h1>

    <c:if test="${sessionScope.user!=null}">
        <form action="controller" method="get">
            <input type="hidden" name="command" value="go_to_basket">
            <input type="hidden" name="user_id" value="${sessionScope.user.id}">
            <button class="subnavcart">Cart</button>
        </form>
    </c:if>

    <form class="sign-out" action="">

    </form>

    <form class="sign-in" action="<c:url value="/signIn"/>">
        <button class="sign-in-btn" type="submit">Log In</button>
    </form>
</div>
</body>
</html>
