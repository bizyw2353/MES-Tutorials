package com.mes.controller;

import com.mes.controller.account.*;
import com.mes.controller.user.*;
import com.mes.util.HibernateUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

    HashMap<String, Controller> router = new HashMap<String, Controller>();

    public FrontController() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        router.put("/main.do", new MainController());
        router.put("/login.do", new LoginController());
        router.put("/loginEnd.do", new LoginProcController());
        router.put("/join.do", new UserCreateController());
        router.put("/joinEnd.do", new UserCreateProcController());
        router.put("/userEdit.do", new UserUpdateController());
        router.put("/userEditEnd.do", new UserUpdateProcController());
        router.put("/userList.do", new UserListController());
        router.put("/accountCreate.do", new AccountCreateController());
        router.put("/accountCreateEnd.do", new AccountCreateProcController());
        router.put("/accountEdit.do", new AccountUpdateController());
        router.put("/accountEditEnd.do", new AccountUpdateProcController());
        router.put("/accountList.do", new AccountListController());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = uri.substring(contextPath.length());

        if (router.containsKey(path)) {
            Controller frontController = router.get(path);
            String method = req.getMethod();
            if (frontController.getMethod().equals(method)) {
                String pagePath = frontController.execute(req, resp);
                if (pagePath != null) {
                    req.getRequestDispatcher(pagePath).forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("/403Error.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("/404Error.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        HibernateUtil.close();
    }
}
