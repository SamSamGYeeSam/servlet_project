package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeDetailDTO;
import com.wanted.crud.dto.EmployeeListDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailDAO {

    private final Connection con;

    public EmployeeDetailDAO(Connection con) {
        this.con = con;
    }

    public EmployeeDetailDTO showEmployeeDetailList(Long empId) throws SQLException {

        EmployeeDetailDTO emp = null;
        String showEmployeeDetailQuery =
                "select e.emp_id, e.emp_name, e.email,e.phone,e.dept_code, d.dept_title,e.job_code ,j.job_name, e.salary,e.hire_date,e.ent_yn as quitstatus "+
                        "from employee e join job j on j.job_code = e.job_code "+
                        " join department d on d.dept_id = e.dept_code "+
                        " where e.emp_id =? ";

        try (PreparedStatement pstmt = con.prepareStatement(showEmployeeDetailQuery)) {
            pstmt.setLong(1, empId);
            ResultSet rest = pstmt.executeQuery();

            if (rest.next()) {
                 emp = new EmployeeDetailDTO(
                        rest.getLong("emp_id"),
                        rest.getString("emp_name"),
                        rest.getString("email"),
                        rest.getString("phone"),
                        rest.getString("dept_code"),
                        rest.getString("dept_title"),
                        rest.getString("job_code"),
                        rest.getString("job_name"),
                        rest.getString("salary"),
                        rest.getDate("hire_date"),
                        rest.getString("quitstatus")
                );
            }
        }
        return emp;

    }
}
