package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Account;
import org.csu.javaweb.domain.Cart;
import org.csu.javaweb.domain.Item;
import org.csu.javaweb.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.FileStore;
import java.util.PrimitiveIterator;

public class RemoveItemFromCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private String UserId;
    private String itemId;
    private Cart cart;
//    private CartService cartService=new CartService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId = request.getParameter("itemId");
        HttpSession session=request.getSession();
        Account account = (Account)session.getAttribute("account");
        UserId=account.getUsername();

        cart = (Cart)session.getAttribute("cart");

        cart.removeItemById(itemId);
        session.setAttribute("cart",cart);
//        cartService.UpDateCart(UserId,cart.getCartItemList());

        request.getRequestDispatcher(VIEW_CART).forward(request, response);
    }
}
