<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보 수정</title>
</head>
<body>
<form id="userEditF" action="/userEditEnd.do" method="post">
    <h1>edit Page</h1>
    <input type="hidden" name="id" value="${user.id}">
    <label>아이디 : </label><input id="userId" name="userId" value="${user.userId}" placeholder="아이디를 입력하세요."><br>
    <label>이름 : </label><input id="name" name="name" value="${user.name}" placeholder="이름를 입력하세요."><br>
    <label>비밀번호 : </label><input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요."><br>


    <button type="button" onclick="editCheck()">수정</button>
    <button type="button" onclick="location.href='main.do'">홈으로</button>

</form>
</body>
</html>
<script>
    function editCheck() {
        const userId = document.getElementById("userId");
        const password = document.getElementById("password");
        const name = document.getElementById("name");

        if (!userId.value) {
            alert('아이디를 입력해주세요');
            userId.focus();
            return false;
        }
        if (!name.value) {
            alert('이름을 입력해주세요.');
            name.focus();
            return false;
        }
        if (!password.value) {
            alert('비밀번호를 입력해주세요.');
            password.focus();
            return false;
        }
        document.getElementById('userEditF').submit();
    }
</script>

