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

<!-- ================= 사원 삭제 form ===================-->
<!-- 삭제 버튼 -->
<button type="button" onclick="openDeleteModal()">삭제</button>

<!-- 배경 어둡게 -->
<div id="modalOverlay" style="
    display:none;
    position:fixed;
    top:0;
    left:0;
    width:100%;
    height:100%;
    background:rgba(0,0,0,0.5);
    z-index:1000;
"></div>

<!-- 삭제 확인 팝업 -->
<div id="deleteModal" style="
    display:none;
    position:fixed;
    top:50%;
    left:50%;
    transform:translate(-50%, -50%);
    background:white;
    padding:30px;
    border-radius:10px;
    text-align:center;
    z-index:1001;
    width:300px;
">

    <p style="font-weight:bold; font-size:16px;">
        정말 삭제하시겠습니까?
    </p>
    <p style="color:red; margin-bottom:20px;">
        되돌릴 수 없습니다.
    </p>

    <!-- 삭제 -->
    <form action="${pageContext.request.contextPath}/employees/delete" method="post" style="display:inline;">
        <input type="hidden" name="empId" value="${employee.empId}">
        <button type="submit" style="
            background:#dc3545;
            color:white;
            padding:8px 15px;
            border:none;
            margin-right:10px;
        ">
            삭제
        </button>
    </form>

    <!-- 취소 -->
    <button onclick="closeDeleteModal()" style="
        background:#6c757d;
        color:white;
        padding:8px 15px;
        border:none;
    ">
        취소
    </button>
</div>

<!-- 스크립트 -->
<script>
    function openDeleteModal() {
        document.getElementById("modalOverlay").style.display = "block";
        document.getElementById("deleteModal").style.display = "block";
    }

    function closeDeleteModal() {
        document.getElementById("modalOverlay").style.display = "none";
        document.getElementById("deleteModal").style.display = "none";
    }
</script>
<!-- ==================================================== -->

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