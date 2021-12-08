<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tsimafeilabanovich
  Date: 7.12.21
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" href="<c:url value="/css/header.css"/>">
</head>
<header>
    <div class="header">

        <div class="logo"><a href="<c:url value="/index.jsp"/>">LOGO</a></div>

        <div class="dropdown">
            <button class="dropbtn">Меню</button>
            <div class="dropdown-content">
                <a href="<c:url value="/deliveredEquipment.jsp"/>">Сданная техника</a>
                <a href="<c:url value="/equipment.jsp"/>">Вся техника</a>
                <a href="<c:url value="/addTechnic.jsp"/>">Добавить технику</a>
                <a href="<c:url value="/addUser.jsp"/>">Добавить пользователя</a>
                <a href="<c:url value="/users.jsp"/>">Пользователи</a>
            </div>
        </div>

    </div>
</header>
</html>
