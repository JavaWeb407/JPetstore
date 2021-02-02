package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Cart;
import org.csu.javaweb.domain.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class updateCartJSServlet extends HttpServlet {

    private Cart cart;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        cart = (Cart)session.getAttribute("cart");

        Iterator<CartItem> cartItemIterator = cart.getAllCartItems();

        while (cartItemIterator.hasNext()) {
            //产品数量增加
            CartItem cartItem = (CartItem) cartItemIterator.next();
            String itemId = cartItem.getItem().getItemId();
            //读取有多少Item
                try {
                    int quantity = Integer.parseInt((String) request.getParameter("quantity"));
                    cart.setQuantityByItemId(itemId, quantity);
                    if (quantity < 1) {
                        cartItemIterator.remove();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                 }
        }
        session.setAttribute("cart", cart);


        Cart cart2 = (Cart)session.getAttribute("cart");
        Iterator<CartItem> cartItemIterator2 = cart2.getAllCartItems();
        String quantityAll = "";
        while (cartItemIterator2.hasNext()) {
            //产品数量增加
            CartItem cartItem2 = cartItemIterator2.next();
            int quantity2 = cartItem2.getQuantity();
            quantityAll += quantity2 + "," + cartItem2.getTotal() + "," + cart2.getSubTotal();

        }

        System.out.println(quantityAll);
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        out.write(quantityAll);

    }
}
