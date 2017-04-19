<%-- 
    Document   : main
    Created on : Sep 19, 2015, 9:17:56 PM
    Author     : Suman
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<nav id="menu">
    <c:if test="${sessionScope.theAdmin.type == 'Admin'}">
        <ul>
            <li><a href="UserController?action=home">Home</a></li>
            <li><a href="StudyController?action=reportedQuestions">Reported Questions</a></li>
        </ul>
    </c:if>
    <c:if test="${sessionScope.theUser.type == 'Participant'}">
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
    </c:if>

</nav>
<%-- Section tag is used to write description  --%>
<section class="main">
    <h3>About us</h3>
    <p>Researchers Exchange Participations is a platform for researchers 
        to exchange participations</p>
    <p>The aim of this platform is to encourage researchers participate in each others
        user studies. Moreover, recruiting serious participants has been always a burden on
        a researcher's shoulder, thus, this platform gives researchers the opportunity
        to do that effectively and in a suitable time.</p>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>