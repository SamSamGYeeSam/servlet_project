package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeListDTO;
import com.wanted.crud.service.EmployeeListService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeListServlet extends HttpServlet {

    private final EmployeeListService employeeListService = new EmployeeListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 로그인 체크
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("loginUser") == null) { // 세션이나 로그인 사용자 정보가 없으면 차단
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        // 2. 서비스 호출
        List<EmployeeListDTO> employeeList = employeeListService.selectAllEmployees();

        // 3. request에 담기
        req.setAttribute("employeeList", employeeList);

        // 4. JSP로 이동
        req.getRequestDispatcher("/view/employee/employeelist.jsp").forward(req, resp);
    }
}
