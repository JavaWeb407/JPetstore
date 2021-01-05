package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Account;
import org.csu.javaweb.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOnFormServlet extends HttpServlet {
    private static final String SignOnForm="/WEB-INF/jsp/account/SignOnForm.jsp";
    private Account account;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(SignOnForm).forward(request, response);
    }
}
