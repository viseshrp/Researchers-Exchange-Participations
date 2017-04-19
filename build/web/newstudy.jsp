<%-- 
    Document   : main
    Created on : Sep 19, 2015, 9:17:56 PM
    Author     : Suman
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<h3 id="page_name">Adding a study</h3>
<%-- Code to go Back to the Main Page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to create new study --%>
<section id="newstudy_form">
    <form action="StudyController?action=add" method="post">
        <label>Study Code *</label>
        <input type="text" name="StudyCode" required /><br>
        <label>Study Name *</label>
        <input type="text" name="study_name" required /><br>
        <label>Question Text *</label>
        <input type="text" name="question_text" required/><br>
        <label>Image *</label>
        <button type="button">Browse</button>
        <br>
        <br>
        <label># Participants *</label>  
        <input type="text" name="participants" required/><br>
        <label># Answers *</label>  
        <select id="question_ans_select" required onchange="change(value)">
            <option value="1" selected="selected">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select><br>        <br>
        <!--        <label>Answer 1 *</label>
                <input type="text" name="study_name" required /><br>
                <label>Answer 2 *</label>
                <input type="text" name="study_name" required /><br>
                <label>Answer 3 *</label>
                <input type="text" name="study_name" required /><br>-->
        <div id="parentDiv">
            <label># Answer 1</label>  
            <input type="text" name="Answer1" required/><br>
        </div>
        <label>Description *</label>  
        <textarea name="description" required></textarea><br>
        <button type="submit"  id="submit_button">Submit</button>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>