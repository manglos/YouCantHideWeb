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
        <title>You Can Login</title>
        <%! String debug="<br>"; %>
        <% if(request.getParameter("debug")!=null)
            debug = request.getParameter("debug")+"<br>"; %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <center>
        <h1>Welcome back! Here's to your successful Log-in, good sir!</h1>
            <%= debug %>
            <br>
            <form action="LogIn" method="POST">
                Enter Username:<br>
                <INPUT TYPE="TEXT" NAME="username" VALUE="manglosc"><BR>
                Enter Password:<br>
                <INPUT TYPE="PASSWORD" NAME="password" VALUE="st1ckman"><BR>
                <INPUT TYPE="SUBMIT"><BR>
            </form>
            <br>
            
        </center>
        <%@include file="footer.jsp" %>
    </body>
</html>
