//package com.wanted.crud.dao;
//
//import com.wanted.crud.dto.EmployeeRegistDTO;
//import com.wanted.crud.global.JDBCTemplate;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class EmployeeRegistDAO {
//
//    // 직원 목록을 받아 리스트로 반환하는 메서드
//    public List<EmployeeRegistDTO> selectAllEmployee() {
//
//        Connection con = null; // DB 연결
//        PreparedStatement pstmt = null; // SQL 실행
//        ResultSet rset = null; // 조회 결과 저장
//
//        // 여러 사원을 담을 리스트
//        List<EmployeeRegistDTO> empList = new ArrayList<>();
//
//
//        String query = "SELECT E.EMP_ID, E.EMP_NAME, E.EMAIL," +
//                " E.PHONE, D.DEPT_TITLE, J.JOB_NAME, E.SALARY," +
//                " E.ENT_YN FROM EMPLOYEE E " +
//                "LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID " +
//                "JOIN JOB J ON E.JOB_CODE = J.JOB_CODE";
//
//        try {
//            //DB 연결 생성
//            con = JDBCTemplate.getConnection();
//            // SQL 실행 준비
//            pstmt = con.prepareStatement(query);
//            // 쿼리 싱행 후 결과 저장
//            rset = pstmt.executeQuery();
//
//            while (rset.next()) {
//                // DTO 객체 생성
//                EmployeeRegistDTO dto = new EmployeeRegistDTO(
//                        rset.getInt("EMP_ID"),
//                        rset.getString("EMP_NAME"),
//                        rset.getString("EMAIL"),
//                        rset.getString("PHONE"),
//                        rset.getString("DEPT_TITLE"),
//                        rset.getString("JOB_NAME"),
//                        rset.getDouble("SALARY"),
//                        rset.getString("ENT_YN")
//                );
//                // DTO 추가
//                empList.add(dto);
//            }
//
//            //예외 발생 시 런타임으로 예외 설정
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//            // 다 닫기
//        } finally {
//            JDBCTemplate.close(rset);
//            JDBCTemplate.close(pstmt);
//            JDBCTemplate.close(con);
//        }
//        return empList;
//
//    }
//
//}
package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeRegistDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRegistDAO {

    public List<EmployeeRegistDTO> selectAllEmployee() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<EmployeeRegistDTO> empList = new ArrayList<>();

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
                EmployeeRegistDTO dto = new EmployeeRegistDTO(
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

    // INSERT 메서드 추가
    public int insertEmployee(EmployeeRegistDTO dto) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;

        String sql = "INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, sal_level, salary, hire_date, ent_yn) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = JDBCTemplate.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(dto.getEmp_id()));
            pstmt.setString(2, dto.getEmp_name());
            pstmt.setString(3, dto.getEmp_no());
            pstmt.setString(4, dto.getEmail());
            pstmt.setString(5, dto.getPhone());
            pstmt.setString(6, dto.getDept_code());
            pstmt.setString(7, dto.getJob_code());
            pstmt.setString(8, dto.getSal_level());  // ← 추가
            pstmt.setInt(9, dto.getSalary());
            pstmt.setDate(10, dto.getHire_Date());
            pstmt.setString(11, dto.getEnt_yn());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("사원 등록 중 DB 오류 발생", e);
        } finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(con);
        }
        return result;
    }
}