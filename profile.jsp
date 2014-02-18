<%-- 
    Document   : profile
    Created on : Mar 7, 2013, 12:23:08 PM
    Author     : Christopher Manglos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="banner.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK href="main.css" rel="stylesheet" type="text/css">
        
        <%! String username=null; %>
        <%! youcanthide.Player me=null; %>
        <%! boolean isUser=false; %>
        
        
        <% username = request.getParameter("un"); %>
        <% isUser = (Boolean)request.getAttribute("isuser"); 
            me = (youcanthide.Player)request.getAttribute("user");
            System.out.println(username + " " + isUser + " " + me);%>      
        
        <title><%= username %>'s Profile Page</title>
        
        
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <% if(isUser)username="Your"; else username+="'s"; %>
        
        
        <h1><%= username %> Profile!</h1>
       
        Username: <%= me.getUsername() %> <% if(isUser){ %><a href="EditControl?un=<%= me.getUsername() %>">edit</a><% } %><br>
        First Name: <%= me.getFirstName() %> <% if(isUser){ %><a href="EditControl?un=<%= me.getUsername() %>">edit</a><% } %><br>
        Last Name: <%= me.getLastName() %> <% if(isUser){ %><a href="EditControl?un=<%= me.getUsername() %>">edit</a><% } %><br>
        Phone Number: <%= me.getPhonenumber() %> <% if(isUser){ %><a href="EditControl?un=<%= me.getUsername() %>">edit</a><% } %><br>
        
        <br>
        <%= me.getFirstName() %> has <h2><%= me.getExperience() %>xp</h2>
        <br>
        
        Logged in <%= me.getLoginCount() %> times. <br>
        
        <% if(isUser){ %><a href="LogOut">Log Out</a><% } %>
        
        
        
        <%@include file="footer.jsp" %>
    </body>
</html>
