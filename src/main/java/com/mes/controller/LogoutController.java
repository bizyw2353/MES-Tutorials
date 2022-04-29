package com.mes.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements Controller{

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return LogoutController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("loginUser") != null) {
            session.invalidate();
            return "/main.jsp";
        }
        return "/main.jsp";
    }
}
