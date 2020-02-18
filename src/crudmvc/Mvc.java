/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import controlador.Controlador;
import modelo.SqlConsultas;
import modelo.Usuario;
import vista.login;
import vista.registro;

/**
 *
 * @author Alejo
 */
public class Mvc {
 public static void main(String []args){
    SqlConsultas consultas=new SqlConsultas();
    Usuario usr=new Usuario();
    login login=new login();
    registro registro=new registro();
    Controlador cont=new Controlador(consultas,usr,login,registro);
    cont.iniciar();
 }
}
