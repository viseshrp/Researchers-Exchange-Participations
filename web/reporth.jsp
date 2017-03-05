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
    <a href="main.jsp?user=Hello,Kim" id="back_to_page">&laquo;Back to the Main Page</a><br><br>


    <%-- Display the reported question status in the table --%>

    <table id="studies_table" >
        <%--Column Names --%>
        <tr>
            <th>Report Date</th>
            <th>Report Question</th>
            <th>Report Status</th>
        </tr>
        <tr>
            <td>01/15/2016</td>
            <td>How much do you...</td>
            <td>Approved</td>
        </tr>
        <tr>
            <td>01/15/2016</td>
            <td>What do you w..</td>
            <td>Pending</td>
        </tr>

    </table>

</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>