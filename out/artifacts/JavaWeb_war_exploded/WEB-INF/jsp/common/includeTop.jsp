<%--
  Created by IntelliJ IDEA.
  User: MAX
  Date: 2020/11/25
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css"
          media="screen" />

    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />
</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="ViewCart"><img align="middle" name="img_cart" src="images/cart.gif" /></a>
            <c:if test="${sessionScope.account == null}">
                <a href="SignOnForm">Sign On</a>
<%--                先跳转到SignOnForm里面,然后再由SignonServlet来处理--%>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <a href="SignOut">Sign Out</a>
                <!---signOut-->
            </c:if>


            <c:if test="${sessionScope.account != null}">
                <img align="middle" src="images/separator.gif" />
                <a href="EditAccount">My Account</a>
            </c:if>

            <a href="../help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="SearchProduct" method="post">
                <input type="text" name="keyword" size="14" />
                <input type="submit" name="searchProducts" value="Search" />
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="ViewCategory?categoryId=FISH"><img
                src="images/sm_fish.gif" />
        </a> <img src="images/separator.gif" />
        <a href="ViewCategory?categoryId=DOGS"><img
                src="images/sm_dogs.gif" />
        </a> <img src="images/separator.gif" />
        <a href="ViewCategory?categoryId=REPTILES"><img
                src="images/sm_reptiles.gif" />
        </a><img src="images/separator.gif" />
        <a href="ViewCategory?categoryId=CATS">
        <img src="images/sm_cats.gif" /></a> <img src="images/separator.gif" />

        <a href="ViewCategory?categoryId=BIRDS"><img src="images/sm_birds.gif" /></a>
    </div>

</div>

<div id="Content">