<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 05.09.16
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ITNavigatorTestTask</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/page.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/page.js"/>"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/jquery.mask.min.js"/>"></script>
</head>
<body>
<div>
    <table>
        <tr>
            <th>ФИО</th>
            <th>Телефон</th>
            <th>Тип</th>
            <th>Комментарий</th>
        </tr>
        <c:forEach items="${fullClients}" var="client" >
            <tr>
                <td>${client.name}</td>
                <td><span id="${client.id}" name="number" onclick="change(this.id, this.attributes['name'].value)">${client.number}</span>
                    <input class="numberInput" id="number${client.id}" type="text">
                </td>
                <td><span id="${client.id}" name="type" onclick="change(this.id, this.attributes['name'].value)">${client.type}</span>
                    <select class="typeList" id="type${client.id}">
                        <option>Домашний</option>
                        <option>Мобильный</option>
                        <option>Нет сведений</option>
                    </select>
                </td>
                <td><span id="${client.id}" name="comment" onclick="change(this.id, this.attributes['name'].value)">${client.comment}</span>
                    <input class="commentInput" id="comment${client.id}" type="text">
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>