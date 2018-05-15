/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UsuarioDAO implements ICrud {

    public UsuarioDAO() {
    }

    public boolean addElemento(Object objetoInsert) {
        Usuario objUsuario = (Usuario) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO USUARIO (LOGIN_USUARIO,PASS_USUARIO,RUT,EDAD,GENERO) VALUES (?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objUsuario.getLogin_usuario());
            ps.setString(2, objUsuario.getPass_usuario());
            ps.setString(3, objUsuario.getRut());
            ps.setInt(4, objUsuario.getEdad());
            ps.setString(5, objUsuario.getGenero());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("error al insertar"+e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al Insertar en la BD" + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Usuario> listadoUsuario = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO ";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario infoUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                listadoUsuario.add(infoUsuario);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoUsuario;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Usuario objUsuario = (Usuario) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE USUARIO SET LOGIN_USUARIO=?,PASS_USUARIO=?,RUT=? WHERE ID_USUARIO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objUsuario.getLogin_usuario());
            ps.setString(2, objUsuario.getPass_usuario());
            ps.setString(3, objUsuario.getRut());
            ps.setInt(4, objUsuario.getId_usuario());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar");
            }
        } catch (Exception e) {
            System.out.println("No se pudo updatear la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM USUARIO WHERE ID_USUARIO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al Eliminar el registros" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar los registros" + e.getMessage());
        }
        return false;
    }

    public Usuario validaUsuario(String user, String pass) {
        Usuario infoUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO WHERE LOGIN_USUARIO=? AND PASS_USUARIO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                infoUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoUsuario;
    }

    public Usuario buscaUsuarioPorId(int id_usuario) {
        Usuario infoUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO WHERE ID_USUARIO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                infoUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoUsuario;
    }

}
