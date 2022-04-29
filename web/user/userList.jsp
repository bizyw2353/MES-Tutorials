<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원목록</title>
</head>
<body>
    <button onclick="location.href='main.do'">홈으로</button>
    <table>
        <tr>
            <th>no</th>
            <th>회원번호</th>
            <th>아이디</th>
            <th>이름</th>
            <th>가입일</th>
        </tr>
        <c:forEach var="user" items="${userList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.id}</td>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.createdAt}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
