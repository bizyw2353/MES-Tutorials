<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-04-28
  Time: 오전 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>홈</title>
</head>
<body>
<h3>메인페이지</h3>
<ul>
    <c:if test="${loginUser eq null}">
    <li><a href="login.do">로그인</a></li>

    <li><a href="join.do">회원가입</a></li>
    </c:if>
    <c:forEach var="user" items="${loginUser}">
        <b> ${user.userId}님 로그인중</b>
        <li><a href="userEdit.do?id=${user.id}">내정보수정</a></li>
        <li><a href="logout.do">로그아웃</a></li>
    </c:forEach>
    <li><a href="userList.do">회원목록 보러가기</a></li>

    <li><a href="accountCreate.do">거래처등록</a></li>
    <li><a href="accountList.do">거래처목록 보러가기</a></li>
</ul>
</body>
</html>
