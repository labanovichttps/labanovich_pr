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

<c:import url="/all_employees"/>

<c:set var="employees" value="${requestScope.employees}"/>

<c:if test="${not empty message}">
    <p style="color: #F88092">${message}</p>
</c:if>
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
                    <c:if test="${technic.status.startsWith('Н')}">
                        <form action="<c:url value="/add_in_st"/>" method="get">
                            <div class="table-dropdown">
                                <button class="table-dropbtn" name="rcID" value="${technic.id}">Сдать</button>
                            </div>
                        </form>
                    </c:if>
                </td>
                <form action="<c:url value="/edit_technic"/>" method="get">
                    <td>
                        <button class="button-change" type="submit" name="technicEdit" value="${technic.id}">Изменить
                        </button>
                    </td>
                </form>
                <form action="<c:url value="/delete_technic"/>" method="get">
                    <td>
                        <button class="button-delete" type="submit" name="technicDelete" value="${technic.id}">Удалить
                        </button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>

</body>
</html>