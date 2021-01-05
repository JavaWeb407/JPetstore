package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Item;
import org.csu.javaweb.domain.Product;
import org.csu.javaweb.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
    private static final String ViewCateGory="WEB-INF/jsp/catalog/Product.jsp";

    private String productId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productId = request.getParameter("productId");
        CatalogService service = new CatalogService();
        Product product = service.getProduct(productId);
        List<Item> itemList = service.getItemListByProduct(productId);

        HttpSession session = request.getSession();
        session.setAttribute("product", product);
        session.setAttribute("itemList", itemList);

        request.getRequestDispatcher(ViewCateGory).forward(request,response);
    }
}
