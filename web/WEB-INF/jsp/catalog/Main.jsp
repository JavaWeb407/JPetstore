<%--
  Created by IntelliJ IDEA.
  User: MAX
  Date: 2020/11/25
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../common/includeTop.jsp"%>
<div id="Content">


    <div id="Welcome">
        <div id="WelcomeContent">
            Welcome to MyPetStore!
        </div>
    </div>

    <div id="Main">
        <div id="Sidebar">
            <div id="SidebarContent">
                <a href="ViewCategory?categoryId=FISH"><img src="images/fish_icon.gif" /></a>
                <br/> Saltwater, Freshwater <br/>
                <a href="ViewCategory?categoryId=DOGS"><img src="images/dogs_icon.gif" /></a>
                <br /> Various Breeds <br />
                <a href="ViewCategory?categoryId=CATS"><img src="images/cats_icon.gif" /></a>
                <br /> Various Breeds, Exotic Varieties <br />
                <a href="ViewCategory?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></a>
                <br /> Lizards, Turtles, Snakes <br />
                <a href="ViewCategory?categoryId=BIRDS"><img src="images/birds_icon.gif" /></a>
                <br /> Exotic Varieties
            </div>
        </div>

        <div id="MainImage">
            <div id="MainImageContent">
                <map name="estoremap">
                    <area alt="Birds" coords="72,2,280,250" href="ViewCategory?categoryId=BIRDS" shape="rect" />
                    <area alt="Fish" coords="2,180,72,250" href="ViewCategory?categoryId=FISH" shape="rect" />
                    <area alt="Dogs" coords="60,250,130,320" href="ViewCategory?categoryId=DOGS" shape="rect" />
                    <area alt="Reptiles" coords="140,270,210,340" href="ViewCategory?categoryId=REPTILES" shape="rect" />
                    <area alt="Cats" coords="225,240,295,310" href="ViewCategory?categoryId=CATS" shape="rect" />
                    <area alt="Birds" coords="280,180,350,250" href="ViewCategory?categoryId=BIRDS" shape="rect" />
                </map>
                <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350" />
            </div>
        </div>
        <div id="Separator">&nbsp;</div>
    </div>

</div>

<%@include file="../common/includeBottom.jsp"%>