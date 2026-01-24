<%-- 
    Document   : login
    Created on : Jan 19, 2026, 9:41:26 AM
    Author     : BAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method = "post">
            <input type="hidden" name="action" value="login">
            username : <input type="text" name="textUserName" required> <br/>
            password: <input type="password" name="textPassword"required> <br/>
            <input type="submit" value="login"> <br/>
            <span style ="color:red" >${message}</span>
        </form>
    </body>
</html>
