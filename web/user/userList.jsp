<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>name</th>
        </tr>
        <c:forEach var="user" items="${userList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.userId}</td>
                <td>${user.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
