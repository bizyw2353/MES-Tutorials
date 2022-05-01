<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>거래처 정보 수정</title>
</head>
<body>
<form id="accountCreateF" action="/accountCreateEnd.do" method="post">
    <h1>Account Create Page</h1>
    <label>거래처 코드 : </label><input id="accountCode" name="accountCode" placeholder="거래처코드를 입력하세요."><br>
    <label>거래처명 : </label><input id="name", name="name", placeholder="거래처명을 입력하세요."><br>

    <button type="button" onclick="accountCreateCheck()">거래처등록</button>
    <button type="button" onclick="location.href='main.do'">홈으로</button>
</form>
</body>
</html>
<script>
    function accountCreateCheck() {
        const accountCode = document.getElementById("accountCode");
        const name = document.getElementById("name");

        if (!accountCode.value) {
            alert('거래처코드를 입력해주세요');
            accountCode.focus();
            return false;
        }
        if (!name.value) {
            alert('거래처명을 입력해주세요.');
            name.focus();
            return false;
        }
        document.getElementById('accountCreateF').submit();
    }
</script>
