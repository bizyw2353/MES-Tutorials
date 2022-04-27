package com.mes.controller;

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

    public FrontController(){
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        router.put("/login.do", new LoginController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = uri.substring(contextPath.length());

        if(router.containsKey(path)){
            Controller frontController = router.get(path);
            String method = req.getMethod();
            if(frontController.getMethod().equals(method)){
                String pagePath = frontController.execute(req, resp);
                if(pagePath != null) {
                    req.getRequestDispatcher(pagePath).forward(req, resp);
                }
            }else{
                System.out.println("403 Error");
            }
        }else{
            System.out.println("404 Error");
        }
    }

    @Override
    public void destroy() {
        HibernateUtil.close();
    }
}
