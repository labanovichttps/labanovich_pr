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
<c:import url="/all_employees"/>

<c:set var="employees" value="${requestScope.employees}"/>

<div class="main">
        <div class="container">

            <h1 class="container-title">
                Сдача техники
            </h1>
            <form action="<c:url value="/add_in_st"/>" method="post">
                <div class="container-fields">
                    <div class="container-field">
                        <div class="field-text">Владелец</div>
                        <select class="input" name="surrenderTecOwnerId">
                            <option hidden></option>
                            <c:forEach items="${employees}" var="empl">
                                <option value="${empl.id}">${empl.name} ${empl.surname}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <button type="submit" class="button">Изменить</button>

                </div>
            </form>

        </div>
    </div>
    
</body>
</html>