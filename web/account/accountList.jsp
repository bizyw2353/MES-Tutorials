<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>거래처목록</title>
</head>
<body>
<button onclick="location.href='main.do'">홈으로</button>
<table>
    <tr>
        <th>no</th>
        <th>거래처번호</th>
        <th>거래처코드</th>
        <th>거래처명</th>
    </tr>
    <c:forEach var="account" items="${accountList}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${account.id}</td>
            <td>${account.accountCode}</td>
            <td><a href="/accountEdit.do?id=${account.id}">${account.name}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
