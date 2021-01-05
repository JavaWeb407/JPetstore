package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Account;
import org.csu.javaweb.service.AccountService;
import org.csu.javaweb.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewAccountServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String NEWACCOUNTFORM = "/WEB-INF/jsp/account/NewAccountForm.jsp";

    private Account account;
    private Account account1;
    private AccountService accountService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        account1 = null;
        session.setAttribute("account", account);


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        String languagePreference = request.getParameter("languagePreference");
        String favouriteCategoryId = request.getParameter("favouriteCategoryId");
        String listOption = request.getParameter("listOption");
        String bannerOption = request.getParameter("bannerOption");

        account1 = new Account();
        account1.setUsername(username);
        account1.setPassword(password);
        account1.setFirstName(firstName);
        account1.setLastName(lastName);
        account1.setEmail(email);
        account1.setPhone(phone);
        account1.setAddress1(address1);
        account1.setAddress2(address2);
        account1.setCity(city);
        account1.setState(state);
        account1.setZip(zip);
        account1.setCountry(country);
        account1.setLanguagePreference(languagePreference);
        account1.setFavouriteCategoryId(favouriteCategoryId);
        account1.setListOption(Boolean.parseBoolean(listOption));
        account1.setBannerOption(Boolean.parseBoolean(bannerOption));

        accountService = new AccountService();
        accountService.insertAccount(account1);

        if (account1 != null) {
            HttpServletRequest httpRequest = request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
            String logInfo = logService.logInfo(" ") + strBackUrl + " 注册新账号";
            logService.insertLogInfo(account1.getUsername(), logInfo);
        }
        request.getRequestDispatcher(MAIN).forward(request, response);

        request.getRequestDispatcher(NEWACCOUNTFORM).forward(request, response);
    }
}

