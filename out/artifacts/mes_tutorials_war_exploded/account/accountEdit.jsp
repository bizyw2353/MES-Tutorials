<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-04-28
  Time: 오전 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>거래처 수정</title>
</head>
<body>
<form id="accountEditF" action="/accountEditEnd.do" method="post">
    <h1>Account Edit Page</h1>
    <input type="hidden" name="id" value="${account.id}">
    <label></label><input id="accountCode" name="accountCode" value="${account.accountCode}" placeholder="거래처 코드"><br>
    <label></label><input id="name" name="name" value="${account.name}" placeholder="거래처명"><br>
    <label></label><input id="tel" name="tel" value="${account.tel}" placeholder="전화번호"><br>
    <label></label><input id="fax" name="fax" value="${account.fax}" placeholder="팩스번호"><br>
    <label></label><input id="email" name="email" value="${account.email}" placeholder="이메일"><br>

    <button onclick="accountEditCheck()">수정</button>
    <button onclick="location.href='main.do'">홈으로</button>
</form>
</body>
</html>
<script>
    function accountEditCheck() {
        const accountCode = document.getElementById("accountCode");
        const name = document.getElementById("name");

        if (!accountCode.value) {
            alert('거래처 코드는 필수 입력사항입니다.');
            accountCode.focus();
            return false;
        }
        if (!name.value) {
            alert('거래처명은 필수 입력사항입니다.');
            name.focus();
            return false;
        }
        document.getElementById('accountCreateF').submit();
    }
</script>
