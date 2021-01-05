package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Account;
import org.csu.javaweb.domain.Order;
import org.csu.javaweb.service.LogService;
import org.csu.javaweb.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewListOrderServlet extends HttpServlet {
    private static final String VIEWLISTORDER = "/WEB-INF/jsp/order/ListOrders.jsp";

    private String username;
    private OrderService orderService;
    private List<Order> orderList = new ArrayList<Order>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        username = request.getParameter("username");
        orderService = new OrderService();
        orderList = orderService.getOrdersByUsername(username);

        HttpSession session = request.getSession();
        session.setAttribute("orderList", orderList);

        //HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account != null) {
            HttpServletRequest httpRequest = request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
            String logInfo = logService.logInfo(" ") + strBackUrl + " 查看订单 " + orderList;
            logService.insertLogInfo(account.getUsername(), logInfo);
        }

        request.getRequestDispatcher(VIEWLISTORDER).forward(request, response);
    }

}
