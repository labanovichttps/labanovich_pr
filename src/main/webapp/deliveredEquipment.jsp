<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='css/delivered equipment.css'>
    <title>Document</title>
</head>
<body>

<jsp:include page="templates/header.jsp"/>

<c:import url="/surrender_technic"/>

<c:set var="sdTech" value="${requestScope.surrender_technicQ}"/>

<c:import url="/all_employees"/>

<c:set var="employees" value="${requestScope.employees}"/>

<c:import url="/all_technic"/>

<c:set var="technics" value="${requestScope.technics}"/>
<div class="main">

    <table class="table">

        <thead>
        <tr>
            <th>ID сданной техники</th>
            <th>Пользователь</th>
            <th>Техника</th>
            <th>Дата сдачи</th>
            <th>Дата возврата</th>
            <th colspan="2">Действия</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${sdTech}" var="tech">
                <tr>
                    <td>${tech.id}</td>
                    <td>
                            ${employees.stream()
                                    .filter(empl-> empl.getId() == tech.userId)
                                    .findFirst()
                                    .get()}

                    </td>
                    <td>${technics.stream()
                            .filter(technics -> technics.getId() == tech.technicId)
                            .findFirst()
                            .get()}
                    </td>
                    <td>${tech.surrenderDate}</td>
                    <td>${tech.receiveDate}</td>
                    <c:if test="${empty tech.receiveDate}">
                        <form action="<c:url value="/receive_surrender_technic"/>" method="get">
                            <td>
                                <button class="button-back" value="${tech.id}" onclick="return confirm('Are you sure you want to receive technic?')" name="reciveTs">Вернуть</button>
                            </td>
                        </form>
                    </c:if>
                    <form action="<c:url value="/EditSurrenderTechnicController"/>" method="get">
                        <td>
                            <input type="hidden" value="${tech.receiveDate}" name="tempDate">
                            <button class="button-detail" value="${tech.id}" name="editTs">Изменить</button>
                        </td>
                    </form>
                </tr>
            </c:forEach>

        </tbody>

    </table>

</div>

</body>
</html>