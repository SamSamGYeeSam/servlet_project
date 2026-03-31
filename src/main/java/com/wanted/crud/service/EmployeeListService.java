package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeListDAO;
import com.wanted.crud.dto.EmployeeListDTO;

import java.sql.SQLException;
import java.util.List;

public class EmployeeListService {

    private final EmployeeListDAO employeeListDAO;

    public EmployeeListService(EmployeeListDAO employeeListDAO) {
        this.employeeListDAO = employeeListDAO;
    }

    public List<EmployeeListDTO> getEmployeeList(){
        try {
            return employeeListDAO.showEmployeeList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
