package com.mes.controller;

import com.mes.dto.UserDto;
import com.mes.entity.User;
import com.mes.service.UserService;
import com.mes.util.HashGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return LoginProcController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String userId = request.getParameter("userId");
        String password = request.getParameter("userPw");
        String md5 = HashGenerator.generateMD5(password);

        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setPassword(md5);

        UserService userService = new UserService();
        boolean result = userService.login(userDto);

        User loginUser = userService.findUserByUserId(userId);
        session.setAttribute("loginUser", userId);



        return null;
    }
}
