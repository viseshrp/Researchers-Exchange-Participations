<%-- 
    Document   : reportques
    Created on : Feb 23, 2017, 1:46:21 PM
    Author     : viseshprasad
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>

<%-- Section to display Reported Questions--%>
<section class="participate">
    <h3><span id="studies">Reported Questions</span></h3>

    <%-- Code to go back to Main page  --%>
    <a href="admin.jsp?user=Admin" id="back_to_page">&laquo;Back to the Main Page</a><br><br>


    <%-- Display the Reported Questions in a table --%>
    <%-- Can click buttons to approve or disapprove--%>

    <table id="studies_table" >
        <%--Column Names --%>
        <tr>
            <th>Question</th>
            <th>Action</th>
        </tr>
        <tr>
            <td>I enjoy outdoor activities</td>
            <td><form action="requestc.jsp?user=Admin&req=approve" method="post">
                    <input type="submit" value="Approve" id="login_button" />
                    <input type="submit" value="Disapprove" id="login_button" onclick="form.action = 'requestc.jsp?user=Admin&req=disapprove'" > 
                </form></td>
        </tr>
        <tr>                    
            <td></td>
            <td></td>
        </tr>

    </table>

</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>