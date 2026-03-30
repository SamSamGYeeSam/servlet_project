package com.wanted.crud.controller;

import com.wanted.crud.dao.EmployeeDetailDAO;
import com.wanted.crud.dto.EmployeeDetailDTO;
import com.wanted.crud.global.JDBCTemplate;
import com.wanted.crud.service.EmployeeDetailService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/employees/detail")
public class EmployeeDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long empId = Long.parseLong(req.getParameter("emp_id"));

        Connection con = JDBCTemplate.getConnection();
        EmployeeDetailDAO dao = new EmployeeDetailDAO(con);
        EmployeeDetailService employeeDetailService  = new EmployeeDetailService(dao);

        EmployeeDetailDTO list = employeeDetailService.getEmployeeDetail(empId);
        req.setAttribute("employeeDetailList",list);

        RequestDispatcher rd = req.getRequestDispatcher("/view/employee/detail.jsp");
        rd.forward(req, resp);
    }
}
