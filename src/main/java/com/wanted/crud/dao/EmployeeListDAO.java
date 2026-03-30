package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeListDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeListDAO {


    public List<EmployeeListDTO> selectAllEmployee() {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        List<EmployeeListDTO> empList = new ArrayList<>();
        String query = "SELECT E.EMP_ID, E.EMP_NAME, E.EMAIL," +
                " E.PHONE, D.DEPT_TITLE, J.JOB_NAME, E.SALARY," +
                " E.ENT_YN FROM EMPLOYEE E " +
                "LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID " +
                "JOIN JOB J ON E.JOB_CODE = J.JOB_CODE";

        try {
            con = JDBCTemplate.getConnection();
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                EmployeeListDTO dto = new EmployeeListDTO(
                        rset.getInt("EMP_ID"),
                        rset.getString("EMP_NAME"),
                        rset.getString("EMAIL"),
                        rset.getString("PHONE"),
                        rset.getString("DEPT_TITLE"),
                        rset.getString("JOB_NAME"),
                        rset.getDouble("SALARY"),
                        rset.getString("ENT_YN")
                );
                empList.add(dto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(con);
        }
        return empList;

    }

}