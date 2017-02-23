<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<nav id="menu">
    <ul>
        <li>Coins (<span class="count">2</span>) </li>
        <li>Participants (<span class="count">3</span>) </li>
        <li>Participation (<span class="count">5</span>) </li>
        <li><br></li>
        <li><a href="home.jsp?user=Hello,Kim">Home</a></li>
        <li><a href="participate.jsp?user=Hello,Kim">Participate</a></li>
        <li><a href="studies.jsp?user=Hello,Kim">My Studies</a></li>
        <li><a href="recommend.jsp?user=Hello,Kim">Recommend</a></li>
        <li><a href="contact.jsp?user=Hello,Kim">Contact</a></li>
    </ul>

</nav>
<%-- Section to display studies and participate in that study--%>
<section class="participate">
    <h3><span id="studies">Studies</span></h3>
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
        </tr>
        <tr>
            <%-- First study details --%>
            <td>GUI</td>
            <td><img src="images/small_tree.jpg" alt="Tree"></td>
            <td>I enjoy outdoor activities</td>
            <td><form action="question.jsp?user=Hello,Kim" method="post"><input type="submit" class="participate_button"
                                                                                value="Participate" /></form></td>

        </tr>
        <tr> 
            <%-- Second study details --%>
            <td>Sec</td>
            <td><img src="images/computer.jpg" alt="Computer"></td>
            <td>I use computers on a daily basis</td> 
            <td><form action="question.jsp?user=Hello,Kim" method="post"><input type="submit" class="participate_button"
                                                                                value="Participate" /></form></td>

        </tr>
        <tr>
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
        </tr>
    </table>

</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>