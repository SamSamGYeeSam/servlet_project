package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeRegistDAO;
import com.wanted.crud.dto.EmployeeRegistDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.util.List;

public class EmployeeRegistService {

    // 서비스에서 DAO 호출
    private final EmployeeRegistDAO employeeRegistDAO = new EmployeeRegistDAO();

    // 직원 목록 반환
    public List<EmployeeRegistDTO> selectAllEmployees() {

        // DB연결
        Connection con = JDBCTemplate.getConnection();

        // SQL 실행
        List<EmployeeRegistDTO> empList = employeeRegistDAO.selectAllEmployee();

        //닫기
        JDBCTemplate.close(con);

        // 서블릿으로 넘기기
        return empList; //d
    }
}