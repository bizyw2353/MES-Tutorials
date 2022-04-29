package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.dto.UserDto;
import com.mes.entity.User;
import com.mes.service.UserService;
import com.mes.util.HashGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountUpdateProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return AccountUpdateProcController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();

        Integer id = Integer.valueOf(request.getParameter("id"));
        String userId = request.getParameter("userId");
        String inputPassword = request.getParameter("password");
        String md5 = HashGenerator.generateMD5(inputPassword);
        String name = request.getParameter("name");

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setUserId(userId);
        userDto.setPassword(md5);
        userDto.setName(name);

        User findUser = userService.findUserById(id);
        if (!findUser.getPassword().equals(md5)) {
            request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
            request.setAttribute("loc", "javascript:history.back()");
        } else {
            User updateUser = userService.updateUser(userDto);

            String msg = (updateUser != null) ? "수정이 완료되었습니다." : "수정 실패했습니다.";
            String loc = (updateUser != null) ? "/main.do" : "javascript:history.back()";

            request.setAttribute("msg", msg);
            request.setAttribute("loc", loc);
        }

        return "/util/msg.jsp";
    }
}
