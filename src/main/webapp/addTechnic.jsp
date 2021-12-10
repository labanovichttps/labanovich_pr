<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='css/add.css'>
    <title>Document</title>
</head>
<body>

<jsp:include page="templates/header.jsp"/>

<div class="main">

    <div class="add-list-container">

        <div class="container-name">Добавление техники</div>

        <form action="<c:url value="/add_technic"/>" method="get">

            <div class="unit">
                <div class="unit-text">Название</div>
                <input type="text" name="tname" pattern="[A-Za-z]{3,30}" required>
            </div>

            <div class="unit">
                <div class="unit-text">Производитель</div>
                <input type="text" pattern="[A-Za-z]{3,30}" name="tproducer" required>
            </div>

            <div class="unit">
                <div class="unit-text">Дата производства</div>
                <input type="date" name="tproduceDate" min="1970-12-10" max="2021-12-10" required>
            </div>

            <div class="unit">
                <div class="unit-text">Срок гарантии</div>
                <input type="date" name="tserviceDate" min="2021-12-10" max="2032-12-10" required>
            </div>

            <div class="unit">
                <div class="unit-text">Цена</div>
                <input pattern="\d+(\.\d{2})?" type="text" name="tcost" required>
            </div>

            <button class="button" type="submit">Добавить</button>

        </form>

    </div>

</div>

</body>
</html>