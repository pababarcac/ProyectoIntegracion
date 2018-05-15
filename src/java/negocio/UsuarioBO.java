/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Usuario;
import persistencia.UsuarioDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UsuarioBO {
    private UsuarioDAO objUsuarioDAO;

    public UsuarioBO() {
        this.objUsuarioDAO= new UsuarioDAO();
    }
    
    public Usuario validaUsuario(String user,String pass){
        return this.objUsuarioDAO.validaUsuario(user, pass);
    }
     public List<Usuario> ListadoUsuarios(){
        return this.objUsuarioDAO.readElementos();
    }
    public Usuario buscaUsuarioPorId(int id){
        return this.objUsuarioDAO.buscaUsuarioPorId(id);
    }
    public boolean updateUsuario(Usuario infoUsuario){
        return this.objUsuarioDAO.updateElemento(infoUsuario);
    }
    public boolean addUsuario(Usuario infoUsuario){
        return this.objUsuarioDAO.addElemento(infoUsuario);
    }
    public boolean deleteUsuario(int id){
        return this.objUsuarioDAO.deleteElemento(id);
    }
}
