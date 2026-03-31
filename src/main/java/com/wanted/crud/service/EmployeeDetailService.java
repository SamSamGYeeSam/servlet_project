package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeDetailDAO;
import com.wanted.crud.dto.EmployeeDetailDTO;

import java.sql.SQLException;

public class EmployeeDetailService {

    private final EmployeeDetailDAO employeeDetailDAO;

    public EmployeeDetailService(EmployeeDetailDAO employeeDetailDAO) {
        this.employeeDetailDAO = employeeDetailDAO;
    }

    public EmployeeDetailDTO getEmployeeDetail(Long empId) {
        try {
            return employeeDetailDAO.showEmployeeDetailList(empId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
