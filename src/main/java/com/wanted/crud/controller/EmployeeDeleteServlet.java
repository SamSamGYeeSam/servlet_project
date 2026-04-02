package com.wanted.crud.controller;

import com.wanted.crud.service.EmployeeDeleteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employees/delete")
public class EmployeeDeleteServlet extends HttpServlet {

    private final EmployeeDeleteService employeeDeleteService = new EmployeeDeleteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 삭제는 GET으로 처리하지 않으므로 목록 페이지로 돌려보냄
        resp.sendRedirect(req.getContextPath() + "/employees");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String empIdParam = req.getParameter("empId");

            if (empIdParam == null || empIdParam.trim().isEmpty()) {
                throw new IllegalArgumentException("empId 값이 전달되지 않았습니다.");
            }

            int empId = Integer.parseInt(empIdParam);

            boolean isDeleted = employeeDeleteService.deleteEmployee(empId);

            if (isDeleted) {
                resp.sendRedirect(req.getContextPath() + "/employees");
            } else {
                throw new RuntimeException("삭제할 사원을 찾지 못했습니다.");
            }

        } catch (NumberFormatException e) {
            throw new ServletException("empId는 숫자여야 합니다.", e);
        } catch (Exception e) {
            throw new ServletException("사원 삭제 중 오류 발생", e);
        }
    }
}