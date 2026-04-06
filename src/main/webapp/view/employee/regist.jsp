<%--<%@ page import="com.wanted.crud.dto.EmployeeRegistDTO" %>--%>
<%--<%@ page import="java.util.List" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: user--%>
<%--  Date: 26. 3. 30.--%>
<%--  Time: 오후 1:15--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%--%>
<%--    List<EmployeeRegistDTO> employeeRegist =--%>
<%--            (List<EmployeeRegistDTO>) request.getAttribute("employeeRegist"); // ← 이거 추가--%>
<%--%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>사원 목록</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>사원 목록</h1>--%>

<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>사번</th>--%>
<%--        <th>이름</th>--%>
<%--        <th>이메일</th>--%>
<%--        <th>전화번호</th>--%>
<%--        <th>부서명</th>--%>
<%--        <th>직급명</th>--%>
<%--        <th>급여</th>--%>
<%--        <th>재직여부</th>--%>
<%--    </tr>--%>

<%--    <%--%>
<%--        if (employeeRegist != null && !employeeRegist.isEmpty()) {--%>
<%--            for (EmployeeRegistDTO employee : employeeRegist) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%= employee.getEmp_id() %></td>--%>
<%--        <td><%= employee.getEmp_name() %></td>--%>
<%--        <td><%= employee.getEmail() %></td>--%>
<%--        <td><%= employee.getPhone() %></td>--%>
<%--        <td><%= employee.getDept_code() %></td>--%>
<%--        <td><%= employee.getJob_code() %></td>--%>
<%--        <td><%= employee.getSalary() %></td>--%>
<%--        <td><%= employee.getEnt_yn() %></td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    } else {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td colspan="8">조회된 사원 정보가 없습니다.</td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = request.getParameter("error");
    String contextPath = request.getContextPath();
%>
<% if ("true".equals(error)) { %>
<script>alert('등록에 실패했습니다. 다시 시도해주세요.');</script>
<% } %>
<html>
<head>
    <meta charset="UTF-8">
    <title>사원 등록</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body { font-family: Arial, sans-serif; background: #f4f6f8; color: #222; padding: 40px; }
        h2 { color: #1f3c88; margin-bottom: 24px; font-size: 24px; }
        .form-group { margin-bottom: 18px; }
        label { display: block; font-weight: bold; margin-bottom: 6px; color: #374151; }
        input, select {
            width: 300px;
            padding: 10px 12px;
            border: 1px solid #cbd5e1;
            border-radius: 8px;
            font-size: 14px;
        }
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
<h2>사원 등록</h2>
<form action="/employees/new" method="post">
    <div class="form-group">
        <label>사번 *</label>
        <input type="number" name="emp_id" required>
    </div>
    <div class="form-group">
        <label>이름 *</label>
        <input type="text" name="emp_name" required>
    </div>
    <div class="form-group">
        <label>주민번호</label>
        <input type="text" name="emp_no">
    </div>
    <div class="form-group">
        <label>이메일</label>
        <input type="email" name="email">
    </div>
    <div class="form-group">
        <label>전화번호</label>
        <input type="text" name="phone">
    </div>
    <div class="form-group">
        <label>부서코드</label>
        <input type="text" name="dept_code">
    </div>
    <div class="form-group">
        <label>직급코드 *</label>
        <input type="text" name="job_code" required>
    </div>
    <div class="form-group">
        <label>급여</label>
        <input type="number" name="salary">
    </div>
    <div class="form-group">
        <label>급여등급</label>
        <input type="text" name="sal_level">
    </div>
    <div class="form-group">
        <label>입사일 (yyyy-MM-dd)</label>
        <input type="date" name="hire_date">
    </div>
    <div class="form-group">
        <label>재직여부</label>
        <select name="ent_yn">
            <option value="N">재직 중</option>
            <option value="Y">퇴사</option>
        </select>
    </div>

    <button type="submit">등록 완료</button>
    <button type="button" onclick="location.href='/employees'">취소</button>
</form>
</body>
</html>