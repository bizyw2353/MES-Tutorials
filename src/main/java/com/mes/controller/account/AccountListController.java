package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.entity.User;
import com.mes.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AccountListController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return AccountListController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = new UserService();
        List<User> userList = userService.findAllUser();

        request.setAttribute("userList", userList);

        return "/user/userList.jsp";
    }
}
