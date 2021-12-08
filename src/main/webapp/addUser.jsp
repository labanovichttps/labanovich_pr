<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='css/add.css'>
    <title>Add user</title>
</head>
<body>

<jsp:include page="templates/header.jsp"/>

<div class="main">

    <div class="add-list-container">

        <div class="container-name">Добавление клиента</div>

        <form action="<c:url value="/add_employee"/>" method="post">

            <div class="unit">
                <div class="unit-text">Имя</div>
                <input type="text" name="eAddName" required>
            </div>

            <div class="unit">
                <div class="unit-text">Фамилия</div>
                <input type="text" name="eAddSurname" required>
            </div>

            <div class="unit">
                <div class="unit-text">Должность</div>
                <input type="text" name="eAddPosition" required>
            </div>

            <div class="unit">
                <div class="unit-text">Номер телефона</div>
                <input type="text" name="eAddPn" required>
            </div>

            <button class="button" type="submit">Добавить</button>

        </form>

    </div>

</div>

</body>
</html>