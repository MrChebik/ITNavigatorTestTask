<%@ page import="ru.mrchebik.model.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.mrchebik.model.TelephoneNumber" %>
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
        <% List<Client> clients = (List) request.getAttribute("clients");
            List<TelephoneNumber> numbers = (List) request.getAttribute("numbers");
            for (int i = 0; i < clients.size(); i++) { %>
            <tr>
                <td><%= clients.get(i).getLastName() %> <%= clients.get(i).getFirstName() %> <%= clients.get(i).getMiddleName() %></td>
                <td><span id="<%= i %>" name="number" onclick="change(this.id, this.attributes['name'].value)"><%= numbers.get(i).getNumber() %></span>
                    <input class="numberInput" id="number<%= i %>" type="text">
                </td>
                <td><span id="<%= i %>" name="type" onclick="change(this.id, this.attributes['name'].value)"><%= numbers.get(i).getType() %></span>
                    <select class="typeList" id="type<%= i %>">
                        <option>Домашний</option>
                        <option>Мобильный</option>
                        <option>Нет сведений</option>
                    </select>
                </td>
                <td><span id="<%= i %>" name="comment" onclick="change(this.id, this.attributes['name'].value)"><%= numbers.get(i).getComment() %></span>
                    <input class="commentInput" id="comment<%= i %>" type="text">
                </td>
            </tr>
        <% } %>
    </table>
</div>
</body>
</html>