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
    <a href="${pageContext.request.contextPath}/WEB-INF/jsp/catalogPage.jsp" class="logo">ChashStore</a>

    <div class="header-right">
        <c:if test="${sessionScope.user!=null}">
            <form action="controller" method="get">
                <input type="hidden" name="command" value="go_to_basket">
                <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                <button class="subnavcart">Cart</button>
            </form>
        </c:if>

        <form class="sign-out" action="${pageContext.request.contextPath}/controller">
            <button class="sign-out-btn" type="submit">Log Out</button>
        </form>

        <form class="sign-in" action="<c:url value="/signIn"/>">
            <button class="sign-in-btn" type="submit">Log In</button>
        </form>
    </div>
</div>
</body>
</html>
