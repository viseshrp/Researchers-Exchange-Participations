<%-- 
    Document   : main
    Created on : Sep 19, 2015, 9:17:56 PM
    Author     : Suman
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<h3 id="page_name">Contact</h3>
<%-- Code to go back to Main page  --%>
<a href="main.jsp?user=Hello,Kim" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to input Contact details and Send Message --%>
<section id="contact_form">
    <form action="confirmc.jsp?user=Hello,Kim" method="post">
        <label>Name *</label>
        <input type="text" name="study_name" required /><br><br>
        <label>Email *</label>
        <input type="email" name="email" required/><br><br>
        <label>Message *</label>  
        <textarea name="message" required></textarea><br>
        <button type="submit"  id="submit_button">Submit</button>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>