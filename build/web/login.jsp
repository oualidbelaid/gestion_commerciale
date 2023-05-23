<%-- 
    Document   : login.jsp
    Created on : 21 mai 2023, 23:15:24
    Author     : dell xps 13 9350
--%>
<%  
    HttpSession s=request.getSession(false);
     
    if(s.getAttribute("username")!=null){
        response.sendRedirect("index.jsp");
    }  
   
%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <% 
            if(request.getAttribute("msg")!=null){
                out.print(request.getAttribute("msg"));
            }
        %>
        <form action="/Project_CAWA/login" method="POST">
            <input type="text" name="username">
             <input type="text" name="password">
              <input type="submit" name="send">
        </form>
    </body>
</html>
