package com.wanted.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.wanted.crud.global.JDBCTemplate.close;

public class EmployeeDeleteDAO {

    public int deleteEmployee(Connection con, int empId) {

        PreparedStatement pstmt = null;
        int result = 0;

        String sql = "DELETE FROM employee WHERE emp_id = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, empId);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("사원 삭제 중 DB 오류 발생", e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}