<%-- 
    Document   : reportques
    Created on : Feb 23, 2017, 1:46:21 PM
    Author     : viseshprasad
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>

<%-- Section to display reported question status--%>
<section class="participate">

    <%-- Code to go back to Main page  --%>
    <a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a><br><br>


    <%-- Display the reported question status in the table --%>

    <table id="studies_table" >
        <%--Column Names --%>
        <tr>
            <th>Report Date</th>
            <th>Report Question</th>
            <th>Report Status</th>
        </tr>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="study" items="${study}">
            <tr>
                <td>${study.dateCreated}</td>
                <td>${study.question}</td>
                <td>${study.status}</td>
            </tr>
        </c:forEach>
    </table>

</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>