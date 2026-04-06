package com.wanted.crud.controller;

import com.wanted.crud.dao.EmployeeUpdateDAO;
import com.wanted.crud.dto.EmployeeUpdateDTO;
import com.wanted.crud.service.EmployeeUpdateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/employees/edit", "/employees/update"})
public class EmployeeUpdateServlet extends HttpServlet {

    private EmployeeUpdateService updateService = new EmployeeUpdateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("empId");

        if (userIdStr == null || userIdStr.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/employees");
            return;
        }

        long userId = Long.parseLong(userIdStr);

        EmployeeUpdateDTO update = updateService.selectUserDetail(userId);

        if (update == null) {
            resp.sendRedirect(req.getContextPath() + "employees");
            return;
        }

        req.setAttribute("update", update);

        req.getRequestDispatcher("/view/employee/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String empId = req.getParameter("empId");
        String empName = req.getParameter("empName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String entYn = req.getParameter("entYn");

        int salary = 0;
        if (req.getParameter("salary") != null && !req.getParameter("salary").isEmpty()) {
            salary = Integer.parseInt(req.getParameter("salary"));
        }

        EmployeeUpdateDTO updateData = new EmployeeUpdateDTO(empId, empName, null, email, phone, null, null, null, salary, 0, 0, null, null, entYn);

        int result = updateService.updateEmployee(updateData);
        if (result > 0) {
            System.out.println(">>> DB 수정 성공: " + empName);
            resp.sendRedirect(req.getContextPath() + "/employees");
        } else {
            System.out.println(">>> DB 수정 실패");
            resp.sendRedirect(req.getContextPath() + "/employees/edit?empId=" + empId + "&error=true");
        }
    }
}
