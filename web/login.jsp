<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-04-28
  Time: 오전 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="loginF" method="post" action="loginEnd.do">
    <h1>Login Page</h1>
    <label>아 이 디 : </label><input id="userId" name="userId" placeholder="아이디를 입력하세요"><br>
    <label>비밀번호 : </label><input id="userPw" name="userPw" placeholder="비밀번호를 입력하세요" type="password"><br>

    <button type="button" onclick="loginCheck()">로그인</button>
    <button type="button" onclick="location.href='main.do'">홈으로</button>

</form>
</body>
</html>

<script>
    function loginCheck() {
        const userId = document.getElementById("userId");
        const userPw = document.getElementById("userPw");

        if (!userId.value) {
            alert('아이디를 입력해주세요');
            userId.focus();
            return false;
        }
        if (!userPw.value) {
            alert('비밀번호를 입력해주세요');
            userPw.focus();
            return false;
        }
        document.getElementById('loginF').submit();
    }
</script>
