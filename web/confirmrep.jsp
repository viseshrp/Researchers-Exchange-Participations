<%-- 
    Document   : confirmrep
    Created on : Feb 23, 2017, 8:47:14 PM
    Author     : viseshprasad
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to go back to Main page  --%>
<br>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section tag is used to confirm reporting   --%>
<section id="confirmc">
    <h3>${requestScope.study.question} Question Reported by ${requestScope.study.email} . . .</h3>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>