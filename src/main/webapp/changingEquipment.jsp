<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='css/changingEquipment.css'>
    <title>Info</title>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<c:import url="/all_technic"/>

<c:set var="technic" value="${requestScope.technic}"/>

<div class="main">
    <div class="container">

        <h1 class="container-title">
            Изменение записи
        </h1>

        <form action="<c:url value="/edit_technic"/>" method="post">
            <div class="container-fields">

            <div class="container-field">
                <div class="field-text">Название техники</div>
                <input class="input" value="${technic.name}" pattern="[A-Za-z]{3,30}" name="nameEdit"  type="text" maxlength="50" required>
            </div>

            <div class="container-field">
                <div class="field-text">Производитель</div>
                <input class="input" value="${technic.producer}" pattern="[A-Za-z]{3,30}" name="producerEdit" type="text" maxlength="50" required>
            </div>

            <div class="container-field">
                <div class="field-text">Дата производства</div>
                <input class="input" value="${technic.produceDate}" name="producerDateEdit" min="1970-12-10" max="2021-12-10" type="date" required
                       maxlength="50">
            </div>

            <div class="container-field">
                <div class="field-text">Срок гарантии</div>
                <input class="input" value="${technic.service_date}" name="serviceDateEdit" min="2021-12-10" max="2032-12-10" type="date" required
                       maxlength="50">
            </div>

            <div class="container-field">
                <div class="field-text">Стоимость</div>
                <input class="input" pattern="\d+(\.\d{2})?" value="${technic.cost}" name="costEdit" type="text" maxlength="50" required>
            </div>

            <button type="submit" value="${technic.id}" onclick="alert('TECHNIC CHANGED')" name="idEdit" class="button">Изменить</button>
            </div>
        </form>

    </div>
</div>

</body>
</html>