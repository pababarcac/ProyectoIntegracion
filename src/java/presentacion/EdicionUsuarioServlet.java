/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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
@WebServlet(name = "EdicionUsuarioServlet", urlPatterns = {"/edicionUsuarioServlet","/editaUsuario"})
public class EdicionUsuarioServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int usuarioEditar=Integer.parseInt(request.getParameter("id_usuario"));
        UsuarioBO objUsuarioBO= new UsuarioBO();
        Usuario infoUsuario=objUsuarioBO.buscaUsuarioPorId(usuarioEditar);
        sesion.setAttribute("usuarioAEditar", infoUsuario);
        response.sendRedirect("IngresoUsuario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();        
        String log=request.getParameter("txtNombreUsuarioEditar");
        String password=request.getParameter("txtPasswordUsuarioEditar");
        String rut=request.getParameter("txtRutUsuarioEditar");
        int edad=Integer.parseInt(request.getParameter("txtEdadUsuarioEditar"));
        String genero=request.getParameter("txtGeneroUsuarioEditar");
        Usuario infoUsuario= new Usuario(log,password,rut,edad,genero);
        infoUsuario.setId_usuario(((Usuario)sesion.getAttribute("usuarioAEditar")).getId_usuario());
        UsuarioBO objUsuarioBO= new UsuarioBO();
        if(objUsuarioBO.updateUsuario(infoUsuario)){
            response.sendRedirect("MantenedorUsuario.jsp");
            sesion.removeAttribute("usuarioAEditar");
        }else{
            sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
            response.sendRedirect("IngresoUsuario.jsp");
        }
    }

}
