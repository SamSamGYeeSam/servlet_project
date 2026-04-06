//package com.wanted.crud.controller;
//
//import com.wanted.crud.dto.EmployeeRegistDTO;
//import com.wanted.crud.service.EmployeeRegistService;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.util.List;
////d
//@WebServlet("/employees/new")
//public class EmployeeRegistServlet extends HttpServlet{
//
//    private final EmployeeRegistService employeeRegistService = new EmployeeRegistService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        // 1. 로그인 체크
//        HttpSession session = req.getSession(false);
//
//        if (session == null || session.getAttribute("loginUser") == null) { // 세션이나 로그인 사용자 정보가 없으면 차단
//            resp.sendRedirect(req.getContextPath() + "/");
//            return;
//        }
//
//        // 2. 서비스 호출
//        List<EmployeeRegistDTO> employeeRegist = employeeRegistService.selectAllEmployees();
//
//        // 3. request에 담기
//        req.setAttribute("employeeRegist", employeeRegist);
//
//        // 4. JSP로 이동
//        req.getRequestDispatcher("/view/employee/regist.jsp").forward(req, resp);
//    }
//}
package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeRegistDTO;
import com.wanted.crud.service.EmployeeRegistService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/employees/new")
public class EmployeeRegistServlet extends HttpServlet {

    private final EmployeeRegistService employeeRegistService = new EmployeeRegistService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        req.getRequestDispatcher("/view/employee/regist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        try {
            int empId = Integer.parseInt(req.getParameter("emp_id"));
            String empName = req.getParameter("emp_name");
            String empNo = req.getParameter("emp_no");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String deptCode = req.getParameter("dept_code");
            String salLevel = req.getParameter("sal_level");
            String jobCode = req.getParameter("job_code");
            int salary = Integer.parseInt(req.getParameter("salary"));
            Date hireDate = Date.valueOf(req.getParameter("hire_date")); // yyyy-MM-dd
            String entYn = req.getParameter("ent_yn");

            EmployeeRegistDTO dto = new EmployeeRegistDTO(
                    empId, empName, empNo, email, phone, deptCode, jobCode, salLevel, salary, hireDate, entYn
            );

            int result = employeeRegistService.insertEmployee(dto);

            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/employees");
            } else {
                resp.sendRedirect(req.getContextPath() + "/employees/new?error=true");
            }

        } catch (Exception e) {
            throw new ServletException("사원 등록 중 오류 발생", e);
        }
    }
}