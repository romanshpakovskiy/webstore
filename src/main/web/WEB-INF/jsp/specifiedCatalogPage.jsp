<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>cat</title>
    <link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

<div class="navbar">
    <div class="subnav">
        <form action="catalogPage.jsp">
            <button class="subnavcatalog">Catalog<i class="fa fa-caret-down"></i></button>
        </form>

        <%-- <div class="subnavcatalog-content">
             <c:forEach items="${applicationScope.categories}" var="category">
                 <a href="controller?commandName=get_categories&category_id=">${category.name}</a>
             </c:forEach>
         </div>--%>
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
