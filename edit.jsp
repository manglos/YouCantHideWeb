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
        <% youcanthide.Player me = (youcanthide.Player)request.getSession().getAttribute("user"); %>
        <% if(request.getParameter("debug")!=null)
            debug = request.getParameter("debug")+"<br>"; %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <center>
            <h1>Edit <%= me.getUsername() %>'s Info</h1>
            <%= debug %>
            <br>
            <form action="EditControl" method="POST">
                First Name:<br>
                <INPUT TYPE="TEXT" NAME="firstName" VALUE=<%= me.getFirstName() %>><BR>
                Last Name:<br>
                <INPUT TYPE="TEXT" NAME="lastName" VALUE=<%= me.getLastName() %>><BR>
                Choose Username:<br>
                <INPUT TYPE="TEXT" NAME="userName" VALUE=<%= me.getUsername() %>><BR>
                Choose Password:<br>
                <INPUT TYPE="PASSWORD" NAME="password" VALUE=<%= me.getPassword() %>><BR>
                Re-type Password:<br>
                <INPUT TYPE="PASSWORD" NAME="password-confirm" VALUE=<%= me.getPassword() %>><BR>
                <INPUT TYPE="SUBMIT"><BR>
            </form>
            <br>
            
        </center>
        
        <%@include file="footer.jsp" %>
    </body>
</html>

