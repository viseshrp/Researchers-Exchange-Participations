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
        <script src="js/rep.js" type="text/javascript"></script>
    </head>
    <body>
        <%-- Code to specify Header section of the page--%>
        <div id="header">
            <nav id="header_menu">
                <ul  class="left" >
                    <li><a href="UserController?action=home">Researchers Exchange Participations</a></li>
                </ul>
                <ul class="right">
                    <c:if test="${sessionScope.theUser == null && sessionScope.theAdmin == null }">
                        <li><a href="UserController?action=about">About Us</a></li>
                        <li><a href="UserController?action=how">How it Works</a></li>
                        <li><a href="login.jsp">Login</a></li>
                        </c:if>
                        <c:if test="${sessionScope.theAdmin.type == 'Admin'}">
                        <li><a href="UserController?action=about">About Us</a></li>
                        <li><a href="UserController?action=how">How it Works</a></li>
                        <li>${sessionScope.theAdmin.name} </li>
                        <li><a href="UserController?action=logout">Logout</a></li>
                        </c:if>
                        <c:if test="${sessionScope.theUser.name != null}">
                        <li><a href="aboutl.jsp?user=${sessionScope.theUser.name}">About Us</a></li>
                        <li><a href="main.jsp?user=${sessionScope.theUser.name}">How it Works</a></li>
                        <li>${sessionScope.theUser.name}</li>
                        <li><a href="UserController?action=logout">Logout</a></li>
                        </c:if>
                </ul>

            </nav>
        </div>