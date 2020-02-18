/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Alejo
 */
public class Uconnection {
 private static Connection con=null;
 public static Connection getConnection(){
     try{
     if(con==null){
      String usr="root";
      String pswe="";
      String url="jdbc:mysql://localhost:3306/registro";
      con=DriverManager.getConnection(url,usr,pswe);
      System.out.println("conectado");
      }
     return con;
     }
      catch(Exception ex){
          ex.printStackTrace();
          throw new RuntimeException(ex);
      }
 }
}


