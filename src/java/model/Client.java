/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author dell xps 13 9350
 */
public class Client {
    public int id;
    public String nom;
    public String telephone;
    public String email;
    
      public Client(   int id,
      String nom,
      String telephone,
      String email){
        this.id=id;
        this.nom=nom;
        this.telephone=telephone;
        this.email=email;
    }
}
