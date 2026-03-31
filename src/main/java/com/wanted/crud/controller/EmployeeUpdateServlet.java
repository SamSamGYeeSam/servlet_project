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
        String name = req.getParameter("name");
        String status = req.getParameter("status");
        String bio = req.getParameter("bio");
        String avatarUrl = req.getParameter("avatarUrl");
        String learningGoal = req.getParameter("learningGoal");

        EmployeeUpdateDTO updateData = new EmployeeUpdateDTO(empId,name, null, null, null, null, null, null, 0, 0, 0, null, null, null);

        resp.sendRedirect(req.getContextPath() + "/employees");
    }
}
