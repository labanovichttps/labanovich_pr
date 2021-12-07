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


<div class="main">

        <table class="table">

            <thead>
                <tr>
                    <th>№</th>
                    <th>Название техники</th>
                    <th>Производитель</th>
                    <th>Дата производства</th>
                    <th>Цена, $</th>
                    <th colspan="2">Действия</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td>1</td>
                    <td>Macbook 1</td>
                    <td>Apple</td>
                    <td>01/01/2001</td>
                    <td>1000</td>
                    <td><button class="button-back">Вернуть</button></td>
                    <td><a href="changingRecords.jsp"><button class="button-detail">Изменить</button></a></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Macbook 1</td>
                    <td>Apple</td>
                    <td>01/01/2001</td>
                    <td>1000</td>
                    <td><button class="button-back">Вернуть</button></td>
                    <td><a href="changingRecords.jsp"><button class="button-detail">Изменить</button></a></td>
                </tr>
            </tbody>

        </table>

    </div>

</body>
</html>