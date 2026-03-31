package com.wanted.crud.controller;

import com.wanted.crud.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //없어도 되지만 혹시 Get 요청이 왔을시.
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");

        //로그인 조건 (아이디 비번 일치해야하고 null값이면 안됌)
        if (userId != null && userPwd != null && loginService.isValidUser(userId, userPwd)) {

            //세션 발급
            HttpSession session = req.getSession(true);
            session.setAttribute("loginUser", userId);
            session.setMaxInactiveInterval(1800); // 30분

        } else {
            //alert로 수정해야함.
            System.out.println("로그인 실패: 아이디 또는 비밀번호 불일치");
        }

        //다 끝난 이후 메인페이지로 이동.
        resp.sendRedirect(req.getContextPath() + "/");
    }
}