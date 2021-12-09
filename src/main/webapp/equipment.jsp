<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='css/equipment.css'>
    <title>Document</title>
</head>
<body>

<jsp:include page="templates/header.jsp"/>

<c:import url="/all_technic"/>

<c:set var="technics" value="${requestScope.technics}"/>

<c:import url="/all_employees"/>

<c:set var="employees" value="${requestScope.employees}"/>

<c:if test="${not empty message}">
    <p style="color: #F88092">${message}</p>
</c:if>

<input type="text" id="search" placeholder="Поиск" onkeyup="tableSearch()">
<button>Word</button>
<button id="btnExport" onclick="fnExcelReport()" >Excel</button>
<div class="main">

    <table class="table" id="info-table">

        <thead>
        <tr>
            <th onclick="sortTableBid(0)" >№</th>
            <th onclick="sortTableBid(1)" >Название техники </th>
            <th onclick="sortTableBid(2)" >Производитель</th>
            <th onclick="sortTableBid(3)" >Дата производства</th>
            <th onclick="sortTableBid(4)" >Цена, $</th>
            <th colspan="3">Действия</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${technics}" var="technic">
            <tr>
                <td>${technic.id}</td>
                <td>${technic.name}</td>
                <td>${technic.producer}</td>
                <td>${technic.produceDate}</td>
                <td>${technic.cost}$</td>
                <td>
                    <c:if test="${technic.status.startsWith('Н')}">
                        <form action="<c:url value="/add_in_st"/>" method="get">
                            <div class="table-dropdown">
                                <button class="table-dropbtn" name="rcID" value="${technic.id}">Сдать</button>
                            </div>
                        </form>
                    </c:if>
                </td>
                <form action="<c:url value="/edit_technic"/>" method="get">
                    <td>
                        <button class="button-change" type="submit" name="technicEdit" value="${technic.id}">Изменить
                        </button>
                    </td>
                </form>
                <form action="<c:url value="/delete_technic"/>" method="get">
                    <td>
                        <button class="button-delete" type="submit" name="technicDelete" value="${technic.id}">Удалить
                        </button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>

</body>
</html>

<script>

    function sortTableBid(n) {
        var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
        table = document.getElementById("info-table");
        switching = true;
        // Set the sorting direction to ascending:
        dir = "asc";
        /* Make a loop that will continue until
        no switching has been done: */
        while (switching) {
            // Start by saying: no switching is done:
            switching = false;
            rows = table.getElementsByTagName("TR");
            /* Loop through all table rows (except the
            first, which contains table headers): */
            for (i = 1; i < (rows.length - 1); i++) {
                // Start by saying there should be no switching:
                shouldSwitch = false;
                /* Get the two elements you want to compare,
                one from current row and one from the next: */
                x = rows[i].getElementsByTagName("TD")[n];
                y = rows[i + 1].getElementsByTagName("TD")[n];
                /* Check if the two rows should switch place,
                based on the direction, asc or desc: */
                if (dir == "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                }
            }
            if (shouldSwitch) {
                /* If a switch has been marked, make the switch
                and mark that a switch has been done: */
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
                // Each time a switch is done, increase this count by 1:
                switchcount ++;
            } else {
                /* If no switching has been done AND the direction is "asc",
                set the direction to "desc" and run the while loop again. */
                if (switchcount == 0 && dir == "asc") {
                    dir = "desc";
                    switching = true;
                }
            }
        }
    }

    function tableSearch() {
        var phrase = document.getElementById('search');
        var table = document.getElementById('info-table');
        var regPhrase = new RegExp(phrase.value, 'i');
        var flag = false;
        for (var i = 1; i < table.rows.length; i++) {
            flag = false;
            for (var j = table.rows[i].cells.length - 1; j >= 0; j--) {
                flag = regPhrase.test(table.rows[i].cells[j].innerHTML);
                if (flag) break;
            }
            if (flag) {
                table.rows[i].style.display = "";
            } else {
                table.rows[i].style.display = "none";
            }

        }
    }

</script>

<script type="text/javascript">
    function fnExcelReport()
    {
        var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
        var textRange; var j=0;
        tab = document.getElementById('info-table'); // id of table

        for(j = 1 ; j < tab.rows.length ; j++)
        {
            tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
//tab_text=tab_text+"</tr>";
        }

        tab_text=tab_text+"</table>";
        tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
        tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
        tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

        var ua = window.navigator.userAgent;
        var msie = ua.indexOf("MSIE ");

        if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) // If Internet Explorer
        {
            txtArea1.document.open("txt/html","replace");
            txtArea1.document.write(tab_text);
            txtArea1.document.close();
            txtArea1.focus();
            sa=txtArea1.document.execCommand("SaveAs",true,"Say Thanks to Sumit.xls");
        }
        else //other browser not tested on IE 11
            sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));

        return (sa);
    }

</script>