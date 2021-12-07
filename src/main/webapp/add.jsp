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

        <div class="container-name">Добавление записи</div>

        <form action="#">

            <div class="unit">
                <div class="unit-text">Text</div>
                <input type="text">
            </div>

            <div class="unit">
                <div class="unit-text">Text</div>
                <input type="text">
            </div>

            <div class="unit">
                <div class="unit-text">Text</div>
                <input type="text">
            </div>

            <div class="unit">
                <div class="unit-text">Text</div>
                <input type="text">
            </div>

            <div class="unit">
                <div class="unit-text">Text</div>
                <input type="text">
            </div>

            <button class="button">Добавить</button>

        </form>

    </div>

</div>

</body>
</html>