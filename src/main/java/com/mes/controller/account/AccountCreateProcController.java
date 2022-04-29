package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.dto.AccountDto;
import com.mes.dto.UserDto;
import com.mes.entity.Account;
import com.mes.entity.User;
import com.mes.service.AccountService;
import com.mes.service.UserService;
import com.mes.util.HashGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountCreateProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return AccountCreateProcController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountCode = request.getParameter("accountCode");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String fax = request.getParameter("fax");
        String email = request.getParameter("email");

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountCode(accountCode);
        accountDto.setName(name);
        accountDto.setTel(tel);
        accountDto.setFax(fax);
        accountDto.setEmail(email);

        AccountService accountService = new AccountService();
        Account createdAccount = accountService.createAccount(accountDto);

        String msg = (createdAccount != null)?"등록이 완료되었습니다.":"등록 실패했습니다.";
        String loc = (createdAccount != null)?"/main.do":"javascript:history.back()";

        request.setAttribute("msg", msg);
        request.setAttribute("loc" , loc);

        return "/util/msg.jsp";
    }
}
