package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.entity.User;
import com.mes.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountUpdateController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return AccountUpdateController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = 82;

        UserService userService = new UserService();
        User user = userService.findUserById(id);

        request.setAttribute("user", user);

        return "/user/userEdit.jsp";
    }
}
