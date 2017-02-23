<%-- 
    Document   : header
    Created on : Sep 19, 2015, 4:50:37 PM
    Author     : Suman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- title of the Page--%>
        <title>Researchers Exchange Participations</title>
        <%-- importing CSS stylesheet --%>
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <body>
        <%-- Code to specify Header section of the page--%>
        <div id="header">
            <nav id="header_menu">
                <ul  class="left" >
                    <li>Researchers Exchange Participations</li>
                </ul>
                <ul class="right">
                    <c:if test="${param.user == null}">
                        <li><a href="about.jsp">About Us</a></li>
                        <li><a href="how.jsp">How it Works</a></li>
                        <li><a href="login.jsp">Login</a></li>
                        </c:if>
                        <c:if test="${param.user != null}">
                        <li><a href="aboutl.jsp?user=Hello,Kim">About Us</a></li>
                        <li><a href="main.jsp?user=Hello,Kim">How it Works</a></li>
                        <li>Hello, Kim</li>
                        </c:if>
                </ul>

            </nav>



        </div>

