<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String empId = (String) request.getAttribute("empId");
  String contextPath = request.getContextPath();
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
    <button class="btn-detail" onclick="location.href='<%= contextPath %>/employees/detail?emp_id=<%= empId %>'">상세조회</button>
    <button class="btn-edit" onclick="location.href='<%= contextPath %>/employees/edit?empId=<%= empId %>'">수정</button>
    <button class="btn-delete" onclick="openDeleteModal()">삭제</button>
    <button class="btn-back" onclick="location.href='<%= contextPath %>/employees'">이전</button>

  </div>
</div>


<!-- 배경 어둡게 -->
<div id="modalOverlay" style="
    display:none;
    position:fixed;
    top:0; left:0;
    width:100%; height:100%;
    background:rgba(0,0,0,0.5);
    z-index:1000;
"></div>

<!-- 삭제 확인 팝업 -->
<div id="deleteModal" style="
    display:none;
    position:fixed;
    top:50%; left:50%;
    transform:translate(-50%, -50%);
    background:white;
    padding:30px;
    border-radius:10px;
    text-align:center;
    z-index:1001;
    width:300px;
">
  <p style="font-weight:bold; font-size:16px;">정말 삭제하시겠습니까?</p>
  <p style="color:red; margin-bottom:20px;">되돌릴 수 없습니다.</p>

  <form action="<%= contextPath %>/employees/delete" method="post" style="display:inline;">
    <input type="hidden" name="empId" value="<%= empId %>">
    <button type="submit" style="background:#dc3545; color:white; padding:8px 15px; border:none; margin-right:10px;">
      삭제
    </button>
  </form>

  <button onclick="closeDeleteModal()" style="background:#6c757d; color:white; padding:8px 15px; border:none;">
    취소
  </button>
</div>

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

</body>
</html>