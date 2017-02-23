<%-- Include tag is used to import header page --%>
<%@include file="header.jsp" %>

<%--Code to signup form --%>
<section id="signup_form">
    <section>
        <form action="main.jsp?user=Hello,Kim" method="post">
            <input type="hidden" name="action" value="signup" />
            <label>Name *</label>
            <input type="text" name="name" required/> <br><br>
            <label>Email *</label>
            <input type="email" name="email" required/> <br><br>
            <label>Password *</label>
            <input type="password" name="password" required/> <br><br>
            <label>Confirm Password *</label>
            <input type="password" name="confirm_password" required /> <br>

            <input type="submit" value="Create Account" id="signup_button">
            <br>
        </form>
    </section>
</section>
<%-- Include tag is used to import footer page --%>
<%@include file="footer.jsp" %>