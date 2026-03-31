package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeListDTO;
import com.wanted.crud.service.EmployeeListService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListDAO {

    private final Connection con;

    public EmployeeListDAO(Connection con) {
        this.con = con;
    }

    public List<EmployeeListDTO> showEmployeeList() throws SQLException {
        List<EmployeeListDTO> employeeList = new ArrayList<>();
        String showEmployeeListQuery =
                "select e.emp_id, e.emp_name, e.email,e.phone, d.dept_title, j.job_name, e.salary, "+
                        "CASE  WHEN ent_yn = 'Y' THEN 'N'\n " +
                        "        WHEN ent_yn = 'N' THEN 'Y'\n " +
                        "    END AS workingstatus "+
                "from employee e join job j on j.job_code = e.job_code "+
                               " join department d on d.dept_id = e.dept_code ";

        try (PreparedStatement pstmt = con.prepareStatement(showEmployeeListQuery)) {
            ResultSet rest = pstmt.executeQuery();

            while (rest.next()) {
                EmployeeListDTO dto = new EmployeeListDTO(
                        rest.getLong("emp_id"),
                        rest.getString("emp_name"),
                        rest.getString("email"),
                        rest.getString("phone"),
                        rest.getString("dept_title"),
                        rest.getString("job_name"),
                        rest.getString("salary"),
                        rest.getString("workingstatus")
                );
                // DTO 추가
                empList.add(dto);
                employeeList.add(dto);
            }
        }
        return employeeList;
    }

}

