<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.wanted.crud.dto.EmployeeListDTO" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>직원 목록</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }
        th { background-color: #1d4ed8; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        tr:hover { background-color: #ddd; }
    </style>
</head>
<body>
<h2>직원 목록</h2>
<table>
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>부서</th>
        <th>직급</th>
        <th>급여</th>
        <th>재직상태</th>
    </tr>
    <%
        List<EmployeeListDTO> employeeList = (List<EmployeeListDTO>) request.getAttribute("employeeList");
        if(employeeList == null || employeeList.isEmpty()) {
    %>
    <tr>
        <td colspan="8">직원 데이터가 없습니다.</td>
    </tr>
    <%
    } else {
        for(EmployeeListDTO emp : employeeList) {
    %>
    <tr onclick="location.href='/employees/button?emp_id=<%= emp.getEmp_id() %>'" style="cursor:pointer;">        <td><%= emp.getEmp_id() %></td>
        <td><%= emp.getEmp_name() %></td>
        <td><%= emp.getEmail() %></td>
        <td><%= emp.getPhone() %></td>
        <td><%= emp.getDept_title() %></td>
        <td><%= emp.getJob_name() %></td>
        <td><%= emp.getSalary() %></td>
        <td><%= emp.getWorkingstatus() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>