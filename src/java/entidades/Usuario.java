/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author amontess
 */
public class Usuario implements Serializable{
    private int id_usuario;
    private String login_usuario;
    private String pass_usuario;
    private String rut;
    private int edad;
    private String genero;

    public Usuario() {
    }

    public Usuario(int id_usuario, String login_usuario, String pass_usuario, String rut, int edad, String genero) {
        this.id_usuario = id_usuario;
        this.login_usuario = login_usuario;
        this.pass_usuario = pass_usuario;
        this.rut = rut;
        this.edad = edad;
        this.genero = genero;
    }

    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    public Usuario(String login_usuario, String pass_usuario, String rut, int edad, String genero) {
        this.login_usuario = login_usuario;
        this.pass_usuario = pass_usuario;
        this.rut = rut;
        this.edad = edad;
        this.genero = genero;
    }

    

    
    
}
