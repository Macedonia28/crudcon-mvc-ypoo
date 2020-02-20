/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.SqlConsultas;
import modelo.Uconnection;
import modelo.Usuario;
import vista.login;
import vista.registro;

/**
 *
 * @author Alejo
 */
public class Controlador implements ActionListener {
 private SqlConsultas consultas;
 
 private Usuario usr;
 private login login;
 private registro registro;
 
public Controlador(SqlConsultas sql,Usuario usr,login login,registro registro){
    this.consultas=sql;
    this.usr=usr;
    this.login=login;
    this.registro=registro;
    this.registro.GUARDAR.addActionListener(this);
} 
    @Override
    public void actionPerformed(ActionEvent ae) {
        
      if(ae.getSource()==registro.GUARDAR){
        
        String password=new  String(registro.txtPassword.getText());
        String password2=new String(registro.txtPassword2.getText());
        usr.setId(registro.txtId.getText());
        usr.setUsuario(registro.txtUsuario.getText());
        usr.setPassword(password);
        usr.setNombre(registro.txtNombre.getText());
        usr.setApellido(registro.txtApellido.getText());
        usr.setCorreo(registro.txtCorreo.getText());
       if(password.equals(password)){
           
          if(consultas.buscar(registro.txtUsuario.getText())==1){
           JOptionPane.showMessageDialog(null,"el ususario ya existe");
       }
           else{
           consultas.insertar(usr);
        } 
       }
       else{
          JOptionPane.showMessageDialog(null,"las contrasenas no son iguales");  
       }
      }
    }
    public void iniciar(){
        this.registro.setVisible(true);
        this.registro.setLocationRelativeTo(null);
    }
}
