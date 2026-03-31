package com.wanted.crud.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet ("/employees/button")
public class EmployeeButtonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("emp_id"); // emp_id만 들고 이동
        req.setAttribute("empId", empId);

        RequestDispatcher rd = req.getRequestDispatcher("/view/employee/button.jsp");
        rd.forward(req, resp);
    }
}
