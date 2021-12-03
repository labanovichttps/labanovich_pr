<%--
  Created by IntelliJ IDEA.
  User: tsimafeilabanovich
  Date: 2.12.21
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Вся техника</title>
</head>
<body>
<c:import url="/all_technic"/>

<c:set var="technics" value="${requestScope.technics}"/>

<h1>List of products from servlet</h1>
<c:forEach var="technic" items="${technics}" varStatus="i">
    ${technic}<br>
</c:forEach>
</body>
</html>
