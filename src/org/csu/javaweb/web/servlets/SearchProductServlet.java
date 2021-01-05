package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Product;
import org.csu.javaweb.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SearchProductServlet extends HttpServlet {
    private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProduct.jsp";
    //keyword是指搜索中的关键字
    private String keyword;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        keyword = request.getParameter("keyword");

        CatalogService service = new CatalogService();
        List<Product> productList = service.searchProductList(keyword);

        //保存数据
        HttpSession session = request.getSession();
        session.setAttribute("keyword", keyword);
        session.setAttribute("productList", productList);

        //跳转页面
        request.getRequestDispatcher(SEARCH_PRODUCTS).forward(request, response);
    }
}
