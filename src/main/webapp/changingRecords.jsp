<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='css/changingRecords.css'>
    <title>Info</title>
</head>
<body>

<jsp:include page="templates/header.jsp"/>


<div class="main">
        <div class="container">

            <h1 class="container-title">
                Изменение записи
            </h1>

            <div class="container-fields">

                <div class="container-field">
                    <div class="field-text">Дата</div>
                    <input class="input" type="date" maxlength="50" required>
                </div>

                <button type="submit" class="button">Изменить</button>

            </div>

        </div>
    </div>
    
</body>
</html>