package com.mes.controller.user;

import com.mes.controller.Controller;
import com.mes.dto.UserDto;
import com.mes.entity.User;
import com.mes.service.UserService;
import com.mes.util.HashGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserCreateProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return UserCreateProcController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String md5 = HashGenerator.generateMD5(password);
        String name = request.getParameter("name");

        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setPassword(md5);
        userDto.setName(name);

        UserService userService = new UserService();
        User createdUser = userService.createUser(userDto);

        String msg = (createdUser != null)?"회원가입이 완료되었습니다.":"회원가입이 실패했습니다.";
        String loc = (createdUser != null)?"/main.do":"javascript:history.back()";

        request.setAttribute("msg", msg);
        request.setAttribute("loc" , loc);

        return "/util/msg.jsp";
    }
}
