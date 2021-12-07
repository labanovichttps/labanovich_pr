<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='css/equipment.css'>
    <title>Document</title>
</head>
<body>

<jsp:include page="templates/header.jsp"/>

<c:import url="/all_technic"/>

<c:set var="technics" value="${requestScope.technics}"/>

<div class="main">

    <table class="table">

        <thead>
        <tr>
            <th>№</th>
            <th>Название техники</th>
            <th>Производитель</th>
            <th>Дата производства</th>
            <th>Цена, $</th>
            <th colspan="3">Действия</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${technics}" var="technic">
            <tr>
                <td>${technic.id}</td>
                <td>${technic.name}</td>
                <td>${technic.producer}</td>
                <td>${technic.produceDate}</td>
                <td>${technic.cost}$</td>
                <td>
                    <div class="table-dropdown">
                        <button class="table-dropbtn">Сдать</button>
                        <div class="table-dropdown-content">
                            <a href="#">login</a>
                            <a href="#">login</a>
                            <a href="#">login</a>
                        </div>
                    </div>
                </td>
                <td><a href="changingEquipment.jsp">
                    <button class="button-change">Изменить</button>
                </a></td>
                <td>
                    <button class="button-delete">Удалить</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>

</body>
</html>