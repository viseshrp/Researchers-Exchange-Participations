<%-- 
    Document   : main
    Created on : Sep 19, 2015, 9:17:56 PM
    Author     : Suman
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<h3 id="page_name">Recommend to a friend</h3>
<%-- Code to display Page Name --%>
<a href="main.jsp?user=Hello,Kim" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to input Contact details and Send Message --%>
<section id="recommend_form">
    <form action="confirmr.jsp?user=Hello,Kim" method="post">
        <label>Name *</label>
        <input type="text" name="study_name" required /><br><br>
        <label>Email *</label>
        <input type="email" name="email" required/><br><br>
        <label>Friend's Email *</label>
        <input type="email" name="friend_email" required/><br><br>
        <label>Message *</label>  
        <textarea name="message" required></textarea><br>
        <button type="submit"  id="submit_button">Submit</button>

    </form>
</section>

<p id="recommend_page_note">When your friend logs in and participates in one user study, you'll get 2 coins bonus</p>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>