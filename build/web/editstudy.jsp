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
<a href="main.jsp?user=Hello,Kim" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to input study details --%>
<section id="newstudy_form">
    <form action="studies.jsp?user=Hello,Kim" method="post">
        <label>Study Name *</label>
        <input type="text" name="study_name" required /><br>
        <label>Question Text *</label>
        <input type="text" name="question_text" required/><br>
        <%-- Img tag is used to import image --%>
        <label>Image *</label>
        <img src="images/placeholder.jpg" id="edit_study_image" alt="Edit"/>
        <button type="button">Browse</button>
        <br>
        <br>
        <label># Participants *</label>  
        <input type="text" name="participants" required/><br>
        <label># Answers *</label>  
        <select id="question_ans_select">
            <option value="1">1</option>
            <option value="2">2</option>
            <option selected="selected" value="3">3</option>
        </select><br><br>
        <label>Answer 1 *</label>
        <input type="text" name="study_name" required /><br>
        <label>Answer 2 *</label>
        <input type="text" name="study_name" required /><br>
        <label>Answer 3 *</label>
        <input type="text" name="study_name" required /><br>

        <label>Description *</label>  
        <textarea name="description" required></textarea><br>
        <button type="submit"  id="submit_button">Update</button>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>