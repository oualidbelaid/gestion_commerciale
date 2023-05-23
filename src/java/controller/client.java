/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import model.Client;
import java.io.*; 
import java.sql.*; 
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*; 

/**
 *
 * @author dell xps 13 9350
 */ 
public class client extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              try{
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection  c= DriverManager.getConnection("jdbc:mysql://localhost:3306/cawa","root",""); 
                      PreparedStatement stmt = c.prepareStatement("SELECT * FROM clients"); 
                        ResultSet rs = stmt.executeQuery();
                        ArrayList<Client> clients=new ArrayList<Client>();
                        while (rs.next()) {
                        int id = rs.getInt("id");
                        String nom = rs.getString("nom");
                         String telephone= rs.getString("telephone");
                         String email = rs.getString("email");  
                         clients.add(new Client(id,nom,telephone,email));
                        }
                           PrintWriter out=response.getWriter();
                           
                          RequestDispatcher rd=request.getRequestDispatcher("clients.jsp");
                          out.print(clients.get(0).nom);
                          //request.setAttribute("cliens", clients.get(0));
                          //rd.forward(request, response);
                        
                }catch(Exception e){
                          
                }
        
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }


}
