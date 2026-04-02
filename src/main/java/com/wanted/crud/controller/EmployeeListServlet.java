package com.wanted.crud.controller;

import com.wanted.crud.dao.EmployeeListDAO;
import com.wanted.crud.dto.EmployeeListDTO;
import com.wanted.crud.global.JDBCTemplate;
import com.wanted.crud.service.EmployeeListService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet ("/employees")
public class EmployeeListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection con = JDBCTemplate.getConnection();
        EmployeeListDAO dao = new EmployeeListDAO(con);
        EmployeeListService employeeListService  = new EmployeeListService(dao);
//getEmployeeList 메서드
        List<EmployeeListDTO> list = employeeListService.getEmployeeList();
        req.setAttribute("employeeList",list);

        RequestDispatcher rd = req.getRequestDispatcher("/view/employee/list.jsp");
        rd.forward(req, resp);
    }
}
