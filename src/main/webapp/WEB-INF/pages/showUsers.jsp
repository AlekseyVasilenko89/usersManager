<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Список пользователей</title>
</head>
<body>
<table border="6">
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>Возраст</td>
        <td>Пароль</td>
        <td>Права</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getAge()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getRole()}</td>
            <td>
                <a href="/update/${user.id}">update</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="add" method="get">
    <input type="submit" value="Добавить нового пользователя">
</form>
</body>
