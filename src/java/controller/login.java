/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.*;
import com.mysql.jdbc.Driver;
/**
 *
 * @author dell xps 13 9350
 */

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

   @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.sendRedirect("login.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       String username= request.getParameter("username");
       String password= request.getParameter("password");
       boolean verified=false;
        if(username.matches("^[a-zA-Z0-9]+$")&& username.length()>=3 && password.length()>=3){
            //check verified in data bases
                try{
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection  c= DriverManager.getConnection("jdbc:mysql://localhost:3306/cawa","root",""); 
                      PreparedStatement stmt = c.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?");
                        stmt.setString(1, username);
                        stmt.setString(2, password);
                        ResultSet rs = stmt.executeQuery();
                        if (rs.next()) {
                            HttpSession s=request.getSession();
                            s.setAttribute("username", username); 
                            response.sendRedirect("index.jsp");
                           
                        } else {
                          request.setAttribute("msg", "Erreur information");
                          RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                          rd.forward(request, response);
                        }
                }catch(Exception e){
                         out.println(e);
                }
        }else{
            request.setAttribute("msg", "Erreur information");

            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }

}
