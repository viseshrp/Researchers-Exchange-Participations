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
<h3 id="add_new_study"><a href="newstudy.jsp?user=${sessionScope.theUser.name}" >Add a new study</a></h3>
 <%-- Code to go Back to the Main Page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
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
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="study" items="${study}">
            <tr>
                <td>${study.studyName}</td>
                <td>${study.requestedParticipants}</td>
                <td>${study.numOfParticipants}</td>
                <td><form action="StudyController?action=start&AMP;StudyCode=${study.studyCode}" method="post"><input type="submit" class="participate_button"
                                                                                                                      value="Start" /></form></td>
                <td><form action="StudyController?action=edit&AMP;StudyCode=${study.studyCode}" method="post"><input type="submit" class="participate_button" value="Edit" /></form></td>                                                
            </tr>
        </c:forEach>
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