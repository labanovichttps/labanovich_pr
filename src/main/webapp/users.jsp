<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='css/users.css'>
    <title>Document</title>
</head>
<body>

<jsp:include page="templates/header.jsp"/>

<c:import url="/all_employees"/>

<c:set var="employees" value="${requestScope.employees}"/>

<c:if test="${not empty message}">
    <p style="color: #F88092">${message}</p>
</c:if>
<div class="main">

    <table class="table">

        <thead>
        <tr>
            <th>Номер</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Должность</th>
            <th>Номер телефона</th>
            <th colspan="3">Действия</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.position}</td>
                <td>${employee.phoneNumber}</td>
                <form action="<c:url value="/edit_employee"/>">
                    <td>
                        <button value="${employee.id}" name="editUser" class="button-change">Изменить</button>
                    </td>
                </form>
                <form action="<c:url value="/delete_employee"/>">
                    <td>
                        <button class="button-delete" value="${employee.id}" name="deleteUser">Удалить</button>
                    </td>
                </form>
            </tr>
        </c:forEach>


        </tbody>

    </table>

</div>


</body>
</html>