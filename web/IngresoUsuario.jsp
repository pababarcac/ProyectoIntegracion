<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>    
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Usuario</title>
    </head>
    <body>
            <c:choose>
                    <c:when test="${sessionScope.usuarioAEditar==null}">
                        <div class="container">
                            <center><h2>Ingresar Usuario</h2></center>
                            <form name="formGuardaUsuarioNuevo" method="post" action="./guardaUsuario">
                              <div class="container">
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input type="text" name="txtNombreUsuarioAdd" class="form-control" placeholder="Nombre del usuario" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Rut</label>
                                        <input type="text" name="txtRutUsuarioAdd" class="form-control" placeholder="Ingrese rut" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Edad</label>
                                        <input type="number" name="txtEdadUsuarioAdd" class="form-control" placeholder="Ingrese edad" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Genero</label>
                                        <input type="text" name="txtGeneroUsuarioAdd" class="form-control" placeholder="Ingrese genero (M-F)" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" name="txtPasswordUsuarioAdd"  class="form-control" placeholder="ingrese password" required/>
                                    </div>
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarUsuarioEditado" value="Guardar"/></center>
                                    </div>
                                </div>                          
                            </form>
                        </div> 
                        <center> <a class="btn" href="MantenedorUsuario.jsp">Volver</a></center>
                        <c:if test="${sessionScope.msgError!=null}">
                            <c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </c:if>
                    </c:when>
                    <c:when test="${sessionScope.usuarioAEditar!=null}">
                        <jsp:useBean id="usuarioAEditar" class="entidades.Usuario" scope="session"></jsp:useBean>
                        <div class="container">
                            <center><h2>Editar Usuario</h2></center>
                            <form name="formGuardaUsuarioEditado" method="post" action="./editaUsuario">
                                <div class="container">
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input type="text" name="txtNombreUsuarioEditar" value="<c:out value="${usuarioAEditar.login_usuario}" ></c:out>" class="form-control" placeholder="Nombre del usuario" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Rut</label>
                                        <input type="text" name="txtRutUsuarioEditar" value="<c:out value="${usuarioAEditar.rut}" ></c:out>" class="form-control" placeholder="Ingrese rut" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Edad</label>
                                        <input type="number" name="txtEdadUsuarioEditar" value="<c:out value="${usuarioAEditar.edad}" ></c:out>" class="form-control" placeholder="Ingrese edad" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Genero</label>
                                        <input type="text" name="txtEdadUsuarioEditar" value="<c:out value="${usuarioAEditar.genero}" ></c:out>" class="form-control" placeholder="Ingrese genero (M-F)" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" name="txtPasswordUsuarioEditar"  class="form-control" placeholder="ingrese password" />
                                    </div>
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarUsuarioEditado" value="Guardar"/></center>
                                    </div>
                                </div>                        
                            </form>
                        </div>
                        <center> <a class="btn" href="MantenedorUsuario.jsp">Volver</a></center>
                        <c:if test="${sessionScope.msgError!=null}">
                            <c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </c:if>
                    </c:when>
                </c:choose>         
    </body>
</html>
