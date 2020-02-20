/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Alejo
 */
public class SqlConsultas {
    public int buscar(String usuario){
        int resultado=0;
        Connection con=Uconnection.getConnection();
        PreparedStatement pst;
        ResultSet rs;
        String sql="Select * from usuarios where ususario=?";
        try{
        pst=con.prepareStatement(sql);
        pst.setString(1,usuario);
        rs=pst.executeQuery();
        if(rs.next()){
            resultado=1;
            return resultado;
        }
        return resultado;
        }catch(Exception ex){
          ex.printStackTrace();
          throw new RuntimeException(ex);
        }
        
    }
 
    public void insertar(Usuario usr){
    Connection con=Uconnection.getConnection();
    PreparedStatement pst;
    
    String sql="INSERT INTO usuarios (id,ususario,password,nombre,apellido,correo)VALUES(?,?,?,?,?,?)";
    try{
     pst=con.prepareStatement(sql);
     pst.setString(1,usr.getId());
     pst.setString(2,usr.getUsuario());
     pst.setString(3,usr.getPassword());
     pst.setString(4,usr.getNombre());
     pst.setString(5,usr.getApellido());
     pst.setString(6,usr.getCorreo());
     pst.executeUpdate();
    }catch(Exception ex){
       ex.printStackTrace();
       throw new RuntimeException(ex);
    }
        
    }
}
