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
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getAge()}</td>
            <td>${user.getPassword()}</td>
            <td>
                <a href="/update/${user.id}">обновить</a>
                <a href="/delete/${user.id}">удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<input value="добавить нового пользывателя" type="button" onclick="location.href='/add'" />
</body>
