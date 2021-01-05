package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Account;
import org.csu.javaweb.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOnServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String SIGNONFORM = "/WEB-INF/jsp/account/SignOnForm.jsp";

    private Account account;
    private AccountService accountService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        accountService = new AccountService();
        account = accountService.getAccount(username, password);

        HttpSession session = request.getSession();
        session.setAttribute("account", account);



        if (account == null){
            session.setAttribute("messageSignOn", "Invalid username or password.  Signon failed.");
            session.setAttribute("account", null);
            request.getRequestDispatcher(SIGNONFORM).forward(request, response);
        }else{
            request.getRequestDispatcher(MAIN).forward(request, response);
        }
    }
}
