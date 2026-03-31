package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeUpdateDAO;
import com.wanted.crud.dto.EmployeeUpdateDTO;
import com.wanted.crud.global.JDBCTemplate;
import java.sql.Connection;

public class EmployeeUpdateService  {

    private EmployeeUpdateDAO updateDAO = new EmployeeUpdateDAO();

    public EmployeeUpdateDTO selectUserDetail(long userId) {
        Connection con = JDBCTemplate.getConnection();
        EmployeeUpdateDTO update = updateDAO.selectUserDetail(con, String.valueOf(userId));
        JDBCTemplate.close(con);

        return update;
    }

}
