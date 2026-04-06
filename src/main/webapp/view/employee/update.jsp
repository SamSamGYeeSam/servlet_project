<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = request.getParameter("error");
%>
<% if ("true".equals(error)) { %>
<script>alert('수정에 실패했습니다. 다시 시도해주세요.');</script>
<% } %>
<html>
<head>
    <meta charset="UTF-8">
    <title>사원정보수정</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body { font-family: Arial, sans-serif; background: #f4f6f8; color: #222; padding: 40px; }
        h2 { color: #1f3c88; margin-bottom: 15px; font-size: 24px; }
        .form-group { margin-bottom: 18px; }
        label { display: block; font-weight: bold; margin-bottom: 6px; color: #374151; }
        input, select {
            width: 300px;
            padding: 10px 12px;
            border: 1px solid #cbd5e1;
            border-radius: 8px;
            font-size: 14px;
        }
        input:disabled { background-color: #f3f4f6; cursor: not-allowed; color: #6b7280; }
        input:focus, select:focus { outline: none; border-color: #2563eb; }
        button {
            padding: 11px 24px;
            border: none;
            border-radius: 10px;
            font-size: 15px;
            font-weight: bold;
            cursor: pointer;
            margin-right: 10px;
            margin-top: 16px;
        }
        button[type="submit"] { background: #2563eb; color: white; }
        button[type="submit"]:hover { background: #1d4ed8; }
        button[type="button"] { background: #e5e7eb; color: #374151; }
        button[type="button"]:hover { background: #d1d5db; }
    </style>
</head>
<body>
<h2>사원 정보 수정 - "${update.emp_Name} 님</h2>

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