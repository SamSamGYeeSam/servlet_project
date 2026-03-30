package com.wanted.crud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post로 받긴하지만 get으로 왔을경우 그냥 처리되게함.
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 기존 세션만
        HttpSession session = req.getSession(false);

        //세션이 있다면 세션을 끊음.
        if(session != null) {
            session.invalidate();
        }

        //세션 파기 후 메인페이지로 리다이렉트
        resp.sendRedirect(req.getContextPath() + "/");
    }
}