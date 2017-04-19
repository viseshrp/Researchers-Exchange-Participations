<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<nav id="menu">
    <ul>
        <li>Coins (<span class="count">${sessionScope.theUser.numCoins}</span>) </li>
        <li>Participants (<span class="count">${sessionScope.theUser.numPostedStudies}</span>) </li>
        <li>Participation (<span class="count">${sessionScope.theUser.numParticipation}</span>) </li>
        <li><br></li>
        <li><a href="UserController?action=main">Home</a></li>
        <li><a href="StudyController?action=participate">Participate</a></li>
        <li><a href="StudyController?action=studies">My Studies</a></li>
        <li><a href="recommend.jsp">Recommend</a></li>
        <li><a href="contact.jsp">Contact</a></li>
    </ul>

</nav>
<%-- Section to display studies and participate in that study and also history of reporting--%>
<section class="participate">
    <h3><span id="studies_new">Studies</span></h3>
    <h3><span id="report_history"><a href="StudyController?action=report&AMP;ReporterEmail=${sessionScope.theUser.email}">Report History</a></span></h3>

    <%-- Display the studies in the table --%>
    <%-- Clicking on Participate button displays Question.jsp page where 
            you can rate the question--%>
    <table id="studies_table" >
        <%--Column Names --%>
        <tr>
            <th>Study Name</th>
            <th>Image</th>		
            <th>Question</th>
            <th>Action</th>
            <th>Report</th>
        </tr>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="study" items="${study}">
            <tr>
                <td>${study.studyName}</td>
                <td><img src="${study.getImageURL(study.studyCode)}" id="question_page_image" alt="Tree"/></td>
                <td>${study.description}</td>
                <td><form action="StudyController?action=participate&AMP;StudyCode=${study.studyCode}" method="post"><input type="submit" class="participate_button"
                                                                                                                            value="Participate" /></form></td>
                <td><form action="StudyController?action=report&AMP;StudyCode=${study.studyCode}&AMP;question=${study.studyName}" method="post"><input type="submit" class="participate_button" value="Report" /></form></td>                                                
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