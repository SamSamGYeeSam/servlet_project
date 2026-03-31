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
    <meta charset="UTF-8">
    <title>사원정보수정</title>
    <style>
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 120px; font-weight: bold; }
        input[readonly] { background-color: #eee; cursor: not-allowed; }
        textarea { width: 300px; height: 100px; vertical-align: top; }
    </style>
</head>
<body>
<h2>사원 정보 수정 - ${update.emp_Name} 님</h2>

<form action="${pageContext.request.contextPath}/employees/update" method="post">

    <input type="hidden" name="empId" value="${update.emp_Id}">
    <div class="form-group">
        <label>사번:</label>
        <input type="text" value="${update.emp_Id}" disabled>
    </div>

    <div class="form-group">
        <label>이름:</label>
        <input type="text" name="empName" value="${update.emp_Name}" required>
    </div>

    <div class="form-group">
        <label>주민번호:</label>
        <input type="text" name="empNo" value="${update.emp_No}">
    </div>

    <div class="form-group">
        <label>이메일:</label>
        <input type="email" name="email" value="${update.email}">
    </div>

    <div class="form-group">
        <label>전화번호:</label>
        <input type="text" name="phone" value="${update.phone}">
    </div>

    <div class="form-group">
        <label>급여:</label>
        <input type="number" name="salary" value="${update.salary}">
    </div>

    <div class="form-group">
        <label>보너스율:</label>
        <input type="text" name="bonus" value="${update.bonus}">
    </div>

    <div class="form-group">
        <label>재직 상태:</label>
        <select name="entYn">
            <option value="N" ${update.ent_yn == 'N' ? 'selected' : ''}>재직 중(Active)</option>
            <option value="Y" ${update.ent_yn == 'Y' ? 'selected' : ''}>퇴사(Retired)</option>
        </select>
    </div>

    <br>
    <button type="submit">수정 완료</button>
    <button type="button" onclick="history.back()">취소</button>
</form>
</body>
</html>