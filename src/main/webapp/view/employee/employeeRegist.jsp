<%@ page import="com.wanted.crud.dto.EmployeeRegistDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오후 5:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<EmployeeRegistDTO> employeeList =
            (List<EmployeeRegistDTO>) request.getAttribute("employeeList");
%>
<html>
<head>
    <title>사원 목록</title>
</head>
<body>
<h1>사원 목록</h1>

<table border="1">
    <tr>
        <th>사번</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>부서명</th>
        <th>직급명</th>
        <th>급여</th>
        <th>재직여부</th>
    </tr>

    <%
        if (employeeList != null && !employeeList.isEmpty()) {
            for (EmployeeRegistDTO employee : employeeList) {
    %>
    <tr>
        <td><%= employee.getEmp_id() %></td>
        <td><%= employee.getEmp_name() %></td>
        <td><%= employee.getEmail() %></td>
        <td><%= employee.getPhone() %></td>
        <td><%= employee.getDept_code() %></td>
        <td><%= employee.getJob_code() %></td>
        <td><%= employee.getSalary() %></td>
        <td><%= employee.getEnt_yn() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="8">조회된 사원 정보가 없습니다.</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>