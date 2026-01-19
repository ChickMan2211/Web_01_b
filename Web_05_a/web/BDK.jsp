<%-- 
    Document   : BDK
    Created on : Jan 19, 2026, 10:01:18 AM
    Author     : BAO
--%>

<%@page import="model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDTO u = (UserDTO) session.getAttribute("user");
            
            if (u != null) {
        %>
        <h1>Welcome, <%=u.getFullName()%> </h1>
        <h2>Bang dieu khien</h2>
        <p>Chuc nang 1</p>
        <p>Chuc nang 2</p>
        <p>Chuc nang 3</p>
        <a href="MainController?action=logout&">Logout</a>
        <%} else {
            response.sendRedirect("login.jsp");
            }
        %>
    </body>
</html>
