<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<script>
    <c:if test="${mes ne null}">
    alert('${msg}');

    </c:if>
  location.href='${loc}';
</script>