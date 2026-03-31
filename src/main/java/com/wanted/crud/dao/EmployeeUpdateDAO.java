package com.wanted.crud.dao;

import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.wanted.crud.global.JDBCTemplate;
import com.wanted.crud.dto.EmployeeUpdateDTO;

public class EmployeeUpdateDAO {

    public EmployeeUpdateDTO selectUserDetail (Connection con, String empId) {
        EmployeeUpdateDTO update = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, " +
                "DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, BONUS, " +
                "MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN " +
                "FROM employee.employee " +
                "WHERE EMP_ID = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, empId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                update = new EmployeeUpdateDTO();
                update.setEmp_Id(rs.getString("EMP_ID"));
                update.setEmp_Name(rs.getString("EMP_NAME"));
                update.setEmp_No(rs.getString("EMP_No"));
                update.setEmail(rs.getString("EMAIL"));
                update.setPhone(rs.getString("PHONE"));
                update.setDept_Code(rs.getString("DEPT_CODE"));
                update.setJob_Code(rs.getString("JOB_CODE"));
                update.setSal_level(rs.getString("SAL_LEVEL"));
                update.setSalary(rs.getInt("SALARY"));
                update.setbonus((int)rs.getFloat("BONUS"));
                update.setManager_id(rs.getInt("MANAGER_ID"));
                update.setHire_date(rs.getDate("HIRE_DATE"));
                update.setEnt_date(rs.getDate("ENT_DATE"));
                update.setEnt_yn(rs.getString("ENT_YN"));
            }

            if (update != null) {
                System.out.println(">>> DAO 조회 성공: " + update.getEmp_Name());
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }

        return update;

    }

}
