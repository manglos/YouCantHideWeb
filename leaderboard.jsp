<%-- 
    Document   : leaderboard
    Created on : Mar 7, 2013, 6:40:24 AM
    Author     : Christopher Manglos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="banner.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK href="main.css" rel="stylesheet" type="text/css">
        
        <title>You Cant Lead</title>
        <jsp:useBean id="leader_board" scope="application" class="youcanthide.LeaderBoard" />
        <jsp:setProperty name="leader_board" property="*" />
        <script src="jquery.js" type="text/javascript"></script>
    <script src="custom.js" type="text/javascript"></script>

    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <h1>Current Leader Board!</h1>
        
        <table class="leaderboard" border="0" width="80%">
            <thead>
                <tr class="leaderboard"">
                    <th><a class="leaderboard" href="LeaderBoardControl?sortby=username">Username</a></th>
                    <th><a class="leaderboard" href="LeaderBoardControl?sortby=firstName">First Name</a></th>
                    <th><a class="leaderboard" href="LeaderBoardControl?sortby=lastName">Last Name</a></th>
                    <th><a class="leaderboard" href="LeaderBoardControl?sortby=xp">Experience Points</a></th>
                </tr>
            </thead>
            <% for(youcanthide.Player p : leader_board.getList()){ %>
            <tr class="leaderboard-alt"><th><a class="leaderboard-alt" href="ProfileControl?un=<%= p.getUsername() %>"><font color="<%= p.getColor() %>"><%= p.getUsername() %></font></a></th>
                <th><%= p.getFirstName() %></th>
                <th><%= p.getLastName() %></th>
                <th><%= p.getExperience() %>xp</th>
            </tr><% } %>
        
            <br>
        </table>
        
        
        <%@include file="footer.jsp" %>
    </body>
</html>
