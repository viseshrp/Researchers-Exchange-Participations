<%-- 
    Document   : requestc
    Created on : Feb 23, 2017, 3:20:44 PM
    Author     : viseshprasad
--%>

<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Code to go back to Main page  --%>
<br>
<a href="admin.jsp?user=${sessionScope.theAdmin.name}" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section tag is used to confirm approval or removal   --%>
<section id="confirmc">
    <c:if test="${param.question == null}">
        <h3>Question Removed..</h3>
    </c:if>
    <c:if test="${param.question != null}">
        <h3>Question Approved..</h3>
    </c:if>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>