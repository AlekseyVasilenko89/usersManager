<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить пользователя</title>
</head>
<body>

Вы действительно хотите удалить пользователя ${user.id}?

<form action="/delete" method="post">
<input type="hidden" name="id" value="${user.id}">
<input type="submit" value="Удалить">
</form>

</body>
</html>