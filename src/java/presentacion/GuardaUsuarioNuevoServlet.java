/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidades.Usuario;
import negocio.UsuarioBO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amontess
 */
@WebServlet(name = "GuardaUsuarioNuevoServlet", urlPatterns = {"/guardaUsuarioNuevoServlet","/guardaUsuario"})
public class GuardaUsuarioNuevoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        String log=request.getParameter("txtNombreUsuarioAdd");
        String password=request.getParameter("txtPasswordUsuarioAdd");
        String rut=request.getParameter("txtRutUsuarioAdd");
        int edad=Integer.parseInt(request.getParameter("txtEdadUsuarioAdd"));
        String genero=request.getParameter("txtGeneroUsuarioAdd");
        Usuario infoUsuario= new Usuario(log,password,rut,edad,genero);
        UsuarioBO objUsuarioBO= new UsuarioBO();
        if(objUsuarioBO.addUsuario(infoUsuario)){
            response.sendRedirect("MantenedorUsuario.jsp");
        }else{
            sesion.setAttribute("msgError", "no se pudo ingresar a la BD");
            response.sendRedirect("IngresoUsuario.jsp");
        }
    }


}
