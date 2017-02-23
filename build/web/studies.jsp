<%-- 
    Document   : main
    Created on : Sep 19, 2015, 9:17:56 PM
    Author     : Suman
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<h3 id="page_name">My Studies</h3>
 <%-- Code to add new study   --%>
<h3 id="add_new_study"><a href="newstudy.jsp?user=Hello,Kim" >Add a new study</a></h3>
 <%-- Code to go Back to the Main Page  --%>
<a href="main.jsp?user=Hello,Kim" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to display studies details --%> 
<%-- Clicking on Start, Stop to Participate in that study and  Edit button to display edit page and edit study details in it--%>
<section id="studies_section">


    <table id="my_studies_table" >
        <tr>
            <th>Study Name</th>
            <th>Requested Participants</th>		
            <th>Participations</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <tr>
            <%-- First study details --%>
            <td>GUI</td>
            <td>10</td>
            <td>3</td>
            <td><button type="button">Start</button></td>
            
            <%-- Code to display edit page --%>
            <td><form action="editstudy.jsp?user=Hello,Kim" method="post">
                    <button type="submit">Edit</button></form></td>

        </tr>
        <%-- Second study details --%>
        <tr>
            <td>Sec</td>
            <td>5</td>
            <td>5</td>
            <td><button type="button">Stop</button></td>
              <%-- Code to display edit page --%>
            <td><form action="editstudy.jsp?user=Hello,Kim" method="post">
                    <button type="submit">Edit</button></form></td>

        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td> 
            <td></td> 
            <td></td> 
        </tr>
        <tr>
            <td></td>
            <td></td> 
            <td></td>
            <td></td> 
            <td></td> 
        </tr>
    </table>

</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>