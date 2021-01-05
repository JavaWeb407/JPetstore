package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Account;
import org.csu.javaweb.domain.Cart;
import org.csu.javaweb.domain.Item;
import org.csu.javaweb.service.CartService;
import org.csu.javaweb.service.CatalogService;
import org.csu.javaweb.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddItemToCartServlet extends HttpServlet {

    //1.处理完请求后的跳转页面
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String SIGNONFORM="/WEB-INF/jsp/account/SignOnForm.jsp";

    //2.定义处理该请求所需要的数据
    private String itemId;
    private Cart cart;             //购物车
    private Account account;


    //3.是否需要调用业务逻辑层
    private CatalogService catalogService;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId = request.getParameter("itemId");
        HttpSession session=request.getSession();
        Account account = (Account)session.getAttribute("account");
        cart=(Cart)session.getAttribute("cart");
        //读取的时候只读取session中的cart,也就是说,数据库只是在每次更改后储存,并不负责输入的功能


        if (account == null){
            session.setAttribute("message", "You must sign on before attempting to check out.  Please sign on and try checking out again.");
            request.getRequestDispatcher(SIGNONFORM).forward(request, response);
        }else {
            if(cart == null)
                cart=new Cart();
            if (cart.containsItemId(itemId)) {
                //已有该物品，数量加一
                cart.incrementQuantityByItemId(itemId);
                HttpServletRequest httpRequest = (HttpServletRequest) request;
                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                Item item = catalogService.getItem(itemId);
                String logInfo = logService.logInfo(" ") + strBackUrl + " " + item + "数量+1 ";
                logService.insertLogInfo(account.getUsername(), logInfo);

            } else {
                catalogService = new CatalogService();
                boolean isInStock = catalogService.isItemInStock(itemId);
                Item item = catalogService.getItem(itemId);
                cart.addItem(item, isInStock);

                session.setAttribute("cart", cart);
                //先把Cart传到session中,然后再写入数据库

                HttpServletRequest httpRequest = request;
                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " 添加物品 " + item + " 到购物车";
                logService.insertLogInfo(account.getUsername(), logInfo);

            }
            request.getRequestDispatcher(VIEW_CART).forward(request, response);
        }
    }
}