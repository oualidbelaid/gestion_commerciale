<%-- 
    Document   : index
    Created on : 22 mai 2023, 01:24:52
    Author     : dell xps 13 9350
--%>
<%  
    HttpSession s=request.getSession(false);
     
    if(s.getAttribute("username")==null){
        response.sendRedirect("login.jsp");
    } 
   else
    {
        String username=s.getAttribute("username").toString(); 
   
%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="/Project_CAWA/logout">logout</a>
        <h1>Hello World! <%
        out.println(username);
%></h1>
    </body>
</html>
<% } %>
