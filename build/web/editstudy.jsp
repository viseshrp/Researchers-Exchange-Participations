<%-- 
    Document   : main
    Created on : Sep 19, 2015, 9:17:56 PM
    Author     : Suman
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<h3 id="page_name">Editing a study</h3>
<%-- Code to go back to Main page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to input study details --%>
<section id="newstudy_form">
    <form action="StudyController?action=update&AMP;StudyCode=${study.studyCode}" method="post">
        <label>Study Name *</label>
        <input type="text" name="study_name" value="${requestScope.study.studyName}" required /><br>
        <label>Question Text *</label>
        <input type="text" name="question_text" value="${requestScope.study.question}" required/><br>
        <%-- Img tag is used to import image --%>
        <label>Image *</label>
        <img src="images/placeholder.jpg" id="edit_study_image" alt="Edit"/>
        <button type="button">Browse</button>
        <br>
        <br>
        <label># Participants *</label>  
        <input type="text" name="participants" value="${requestScope.study.numOfParticipants}" required/><br>
        <%-- Adding answers dropdown and answers text boxes dynamically--%>
        <label># Answers *</label>  
        <select id="studySelect" onchange="change(value)">
            <option value=1>1</option>
            <option value=2>2</option>
            <option value=3 >3</option>
            <option value=0 selected>select</option>
        </select><br><br>
        <div id="parentDiv">
        </div>
        <label>Description *</label>  
        <textarea name="description"  required>${requestScope.study.description}</textarea><br>
        <button type="submit"  id="submit_button">Update</button>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>