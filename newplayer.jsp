<%-- 
    Document   : needlogin
    Created on : Mar 9, 2013, 9:38:23 AM
    Author     : Christopher Manglos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="banner.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK href="main.css" rel="stylesheet" type="text/css">
        <title>You Don't Exist</title>
        <%! String debug="<br>"; %>
        <% if(request.getParameter("debug")!=null)
            debug = request.getParameter("debug")+"<br>"; %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <center>
        <h1>New Player Sign-In</h1>
            <%= debug %>
            <br>
            <form action="NewPlayer" method="POST">
                First Name:<br>
                <INPUT TYPE="TEXT" NAME="firstName" VALUE="Christopher"><BR>
                Last Name:<br>
                <INPUT TYPE="TEXT" NAME="lastName" VALUE="Manglos"><BR>
                Choose Username:<br>
                <INPUT TYPE="TEXT" NAME="userName" VALUE="manglosc"><BR>
                Choose Password:<br>
                <INPUT TYPE="PASSWORD" NAME="password" VALUE="st1ckman"><BR>
                Re-type Password:<br>
                <INPUT TYPE="PASSWORD" NAME="password-confirm" VALUE="st1ckman"><BR>
                Phone Number:<br>
                <INPUT TYPE="TEXT" NAME="phoneNumber" VALUE="3155294890"><BR>
                XP (tentative field):<br>
                <INPUT TYPE="TEXT" NAME="xp" VALUE="100"><BR>
                is in a game? (tentative field):<br>
                <INPUT TYPE="TEXT" NAME="ingame" VALUE="0"><BR>
                <INPUT TYPE="SUBMIT"><BR>
            </form>
            <br>
            
        </center>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
