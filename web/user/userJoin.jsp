<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form id="joinF" action="/joinEnd.do" method="post">
    <h1>join Page</h1>
    <label>아이디 : </label><input id="userId" name="userId" placeholder="아이디를 입력하세요."><br>
    <label>비밀번호 : </label><input id="password" name="password" type="password" placeholder="비밀번호를 입력하세요."><br>
    <label>비밀번호 확인 : </label><input id="checkpw" type="password" placeholder="비밀번호를 한번 더 입력하세요."><br>
    <label>이름 : </label><input id="name" name="name" placeholder="이름를 입력하세요."><br>

    <button type="button" onclick="joinCheck()">회원가입</button>
    <button type="button" onclick="location.href='main.do'">홈으로</button>

</form>
</body>
</html>
<script>
    function joinCheck() {
    const userId = document.getElementById("userId");
    const password = document.getElementById("password");
    const checkpw = document.getElementById("checkpw");
    const name = document.getElementById("name");

    if (!userId.value) {
        alert('아이디를 입력해주세요');
        userId.focus();
        return false;
    }
    if (!password.value) {
        alert('비밀번호를 입력해주세요.');
        password.focus();
        return false;
    }
    if (!name.value) {
        alert('이름을 입력해주세요.');
        name.focus();
        return false;
    }
    if (password.value != checkpw.value) {
        alert('비밀번호가 일치하지 않습니다.');
        checkpw.focus();
        return false;
    }
    document.getElementById('joinF').submit();
    }
</script>
