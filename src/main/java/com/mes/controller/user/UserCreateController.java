package com.mes.controller.user;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserCreateController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return UserCreateController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "/user/userJoin.jsp";
    }
}
