package com.mes.controller.user;

import com.mes.controller.Controller;
import com.mes.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class CheckUserId implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CheckUserId.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        response.getWriter().write(checkUserId(userId)+"");
        return null;
    }

    private int checkUserId(String userId) {
        UserService userService = new UserService();
        return 1;
    }
}
