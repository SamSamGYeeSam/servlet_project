<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.wanted.crud.dto.EmployeeDetailDTO" %>
<%
    EmployeeDetailDTO emp = (EmployeeDetailDTO) request.getAttribute("employeeDetailList");
%>
<html>
<head>
    <title>사원 상세</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 10px; }
        th { background-color: #1d4ed8; color: white; width: 150px; }
        .btn-wrap { display: flex; gap: 10px; margin-top: 20px; }
        button {
            padding: 10px 20px;
            cursor: pointer;
            font-size: 14px;
            border: none;
            border-radius: 8px;
            background-color: #e5e7eb;
            color: black;
            transition: background 0.2s;
        }
        button:hover { background-color: #d1d5db; }
    </style>
</head>
<body>
<h2>사원 상세 조회</h2>

<table>
    <tr><th>사번</th><td><%= emp.getEmp_id() %></td></tr>
    <tr><th>이름</th><td><%= emp.getEmp_name() %></td></tr>
    <tr><th>이메일</th><td><%= emp.getEmail() %></td></tr>
    <tr><th>전화번호</th><td><%= emp.getPhone() %></td></tr>
    <tr><th>부서코드</th><td><%= emp.getDept_code() %></td></tr>
    <tr><th>부서명</th><td><%= emp.getDept_title() %></td></tr>
    <tr><th>직급코드</th><td><%= emp.getJob_code() %></td></tr>
    <tr><th>직급명</th><td><%= emp.getJob_name() %></td></tr>
    <tr><th>급여</th><td><%= emp.getSalary() %></td></tr>
    <tr><th>입사일</th><td><%= emp.getHire_Date() %></td></tr>
    <tr><th>퇴직여부</th><td><%= emp.getQuitstatus() %></td></tr>
</table>

<div class="btn-wrap">
    <button onclick="location.href='/employees/button?emp_id=<%= emp.getEmp_id() %>'">이전</button>
</div>
</body>
</html>