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
    <%--    <a href="index.jsp" style="font-family:Bahnschrift sans-serif; padding-left: 5px; width: 105%;--%>
    <%--text-de">storesname.com</a>--%>
    <h1 style="font-family: 'Berlin Sans FB',sans-serif;font-weight: lighter; padding-right: 50%">choose from the best</h1>
    <form class="sign-in" action="<c:url value="/signIn"/>">
        <button class="sign-in-btn" type="submit">Log In</button>
    </form>
</div>
</body>
</html>
