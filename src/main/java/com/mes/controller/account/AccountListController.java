package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.entity.Account;
import com.mes.entity.User;
import com.mes.service.AccountService;
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

        AccountService accountService = new AccountService();
        List<Account> accountList = accountService.findAllUser();

        request.setAttribute("accountList", accountList);

        return "/account/accountList.jsp";
    }
}
