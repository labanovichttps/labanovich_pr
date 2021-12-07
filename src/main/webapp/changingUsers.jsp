<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='css/changingUsers.css'>
    <title>Info</title>
</head>
<body>

<jsp:include page="templates/header.jsp"/>
<c:import url="/all_employees"/>

<c:set var="employee" value="${requestScope.employee}"/>

<div class="main">
    <div class="container">

        <h1 class="container-title">
            Изменение записи
        </h1>

        <form action="<c:url value="/edit_employee"/>" method="post">
            <div class="container-fields">

                <div class="container-field">
                    <div class="field-text">Имя</div>
                    <input class="input" value="${employee.name}" name="name" type="text" maxlength="50">
                </div>

                <div class="container-field">
                    <div class="field-text">Фамилия</div>
                    <input class="input" value="${employee.surname}" name="surname" type="text" maxlength="50">
                </div>

                <div class="container-field">
                    <div class="field-text">Должность</div>
                    <input class="input" value="${employee.position}" name="position" type="text" maxlength="50">
                </div>

                <div class="container-field">
                    <div class="field-text">Номер телефона</div>
                    <input class="input" value="${employee.phoneNumber}" name="phone_number" type="text" maxlength="50">
                </div>

                <button value="${employee.id}" name="id" type="submit" class="button">Изменить</button>

            </div>

        </form>


    </div>
</div>

</body>
</html>