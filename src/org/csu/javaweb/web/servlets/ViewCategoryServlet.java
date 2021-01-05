package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Category;
import org.csu.javaweb.domain.Product;
import org.csu.javaweb.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewCategoryServlet")
public class ViewCategoryServlet extends HttpServlet {
    private String categoryId;
    private static final String ViewCateGory="WEB-INF/jsp/catalog/Category.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryId=request.getParameter("categoryId");
        CatalogService service=new CatalogService();
        Category category=service.getCategory(categoryId);
        List<Product> productList=service.getProductListByCategory(categoryId);

        HttpSession session=request.getSession();
        session.setAttribute("category",category);
        session.setAttribute("productList",productList);

        request.getRequestDispatcher(ViewCateGory).forward(request,response);
    }
}
