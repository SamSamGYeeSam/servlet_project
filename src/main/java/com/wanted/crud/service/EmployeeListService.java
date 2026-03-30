package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeListDAO;
import com.wanted.crud.dto.EmployeeListDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.util.List;

public class EmployeeListService {

    // 서비스에서 DAO 호출
    private final EmployeeListDAO employeeListDAO = new EmployeeListDAO();

    // 직원 목록 반환
    public List<EmployeeListDTO> selectAllEmployees() {

        // DB연결
        Connection con = JDBCTemplate.getConnection();

        // SQL 실행
        List<EmployeeListDTO> empList = employeeListDAO.selectAllEmployee();

        //닫기
        JDBCTemplate.close(con);

        // 서블릿으로 넘기기
        return empList;
    }
}