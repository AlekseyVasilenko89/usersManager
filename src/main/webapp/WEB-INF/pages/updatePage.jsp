<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать пользователя.

<form action="/update" method="post">
    <input type="hidden" name="id" value="${user.id}" placeholder=${param.id}>
    <input type="text" name="name" value="${user.name}" placeholder=${param.name}>
    <input type="text" name="age" value="${user.age}" placeholder=${param.age}>
    <input type="text" name="password" value="${user.password}" placeholder=${param.password}>
    <input type="submit" value="Обновить">
</form>
</body>
</html>