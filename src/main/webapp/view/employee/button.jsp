<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String empId = (String) request.getAttribute("empId");
%>
<html>
<head>
  <title>메뉴 선택</title>
  <style>
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f4ff;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .container {
      background: white;
      border-radius: 16px;
      box-shadow: 0 4px 20px rgba(0,0,0,0.1);
      padding: 40px;
      text-align: center;
      width: 360px;
    }
    h2 { color: #1d4ed8; margin-bottom: 30px; font-size: 22px; }
    .btn-wrap { display: flex; flex-direction: column; gap: 12px; }
    button { padding: 14px; font-size: 15px; border: none; border-radius: 8px; cursor: pointer; transition: background 0.2s; }
    .btn-detail { background-color: #e5e7eb; color: black; }
    .btn-detail:hover { background-color: #d1d5db; }
    .btn-edit { background-color: #e5e7eb; color: black; }
    .btn-edit:hover { background-color: #d1d5db; }
    .btn-delete { background-color: #e5e7eb; color: black; }
    .btn-delete:hover { background-color: #d1d5db; }
    .btn-back { background-color: #e5e7eb; color: black; }
    .btn-back:hover { background-color: #d1d5db; }
  </style>
</head>
<body>
<div class="container">
  <h2>메뉴 선택</h2>
  <div class="btn-wrap">
    <button class="btn-detail" onclick="location.href='/employees/detail?emp_id=<%= empId %>'">상세조회</button>
    <button class="btn-edit" onclick="location.href='/employees/edit?emp_id=<%= empId %>'">수정</button>
    <button class="btn-delete" onclick="location.href='/employees/delete?emp_id=<%= empId %>'">삭제</button>
    <button class="btn-back" onclick="location.href='/employees'">이전</button>
  </div>
</div>
</body>
</html>