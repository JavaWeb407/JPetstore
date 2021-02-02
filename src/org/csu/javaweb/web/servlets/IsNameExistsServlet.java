package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Account;
import org.csu.javaweb.service.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class IsNameExistsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Account account = new Account();
        account.setUsername(username);
        AccountService accountService = new AccountService();

        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();

        if(accountService.getAccount(account.getUsername()) != null){
            out.println("<msg>Exist</msg>");
        }
        else {
            out.println("<msg>NotExist</msg>");
        }
        out.flush();
        out.close();
    }
}
