/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

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
@WebServlet(name = "EliminaUsuarioServlet", urlPatterns = {"/eliminaUsuarioServlet","/eliminaUsuario"})
public class EliminaUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        int id_usuario=Integer.parseInt(request.getParameter("id_usuario_elimina"));
        UsuarioBO objUsuarioBO= new UsuarioBO();
        if(objUsuarioBO.deleteUsuario(id_usuario)){
            response.sendRedirect("MantenedorUsuario.jsp");
        }else{
            sesion.setAttribute("msgErrorElimina", "No se pudo eliminar el usuario");
            response.sendRedirect("MantenedorUsuario.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

}
