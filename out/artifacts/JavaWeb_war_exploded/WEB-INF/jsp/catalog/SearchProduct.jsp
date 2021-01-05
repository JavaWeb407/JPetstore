<%--
  Created by IntelliJ IDEA.
  User: MAX
  Date: 2020/12/22
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/includeTop.jsp"%>
<div id="BackLink">
    <a href="main" >
        Return to Main Menu
    </a>
</div>

<div id="Catalog">

    <table>
        <tr>
            <th>&nbsp;</th>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${sessionScope.productList}">
            <tr>
                <td>
                    <a href="ViewProduct?productId=${product.productId}">${product.description}</a>
                </td>
                <td><b>
                    <a href="ViewProduct?productId=${product.productId}">${product.productId}</a>
                </b></td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
        </tr>

    </table>

</div>

<%@ include file="../common/includeBottom.jsp"%>