<%-- 
    Document   : clients
    Created on : 23 mai 2023, 10:30:02
    Author     : dell xps 13 9350
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
   <thead>
      <tr>
         <th>Product ID</th>
         <th>Product Name</th>
         <!-- Add more columns as needed -->
      </tr>
   </thead>
   <tbody> 
       <%= request.getAttribute("clients") %>
   </tbody>
</table>

        <h1>Hello World!</h1>
    </body>
</html>
