package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeDeleteDAO;

import java.sql.Connection;

import static com.wanted.crud.global.JDBCTemplate.close;
import static com.wanted.crud.global.JDBCTemplate.getConnection;

public class EmployeeDeleteService {

    private final EmployeeDeleteDAO employeeDeleteDAO = new EmployeeDeleteDAO();

    public boolean deleteEmployee(int empId) {

        Connection con = getConnection();

        try {
            int result = employeeDeleteDAO.deleteEmployee(con, empId);
            return result > 0;
        } finally {
            close(con);
        }
    }
}