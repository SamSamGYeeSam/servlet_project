<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    // ================= 직원 삭제 form ===================
    <form action="${pageContext.request.contextPath}/employees/delete" method="post"
        onsubmit="return confirm('정말 삭제하시겠습니까?');">
        <input type="hidden" name="empId" value="${employee.empId}">
        <button type="submit">삭제</button>
    </form>
    // ====================================================

</body>
</html>
