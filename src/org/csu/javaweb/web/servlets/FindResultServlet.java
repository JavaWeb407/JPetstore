package org.csu.javaweb.web.servlets;

import org.csu.javaweb.domain.Product;
import org.csu.javaweb.service.CatalogService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FindResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取搜索框输入的内容
        String keyword = request.getParameter("keyword");
        //向server层调用相应的业务
        CatalogService service = new CatalogService();
        List<Product> productList = service.searchProductList(keyword);

        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();

        //返回结果
        String res = "";
        for(int i=0; i<productList.size(); i++){
            if(i>0){
                res += "," + productList.get(i);
            }else{
                res += productList.get(i);
            }
        }
        out.println("<result>"+res+"</result>");
        out.flush();
        out.close();

    }
}
