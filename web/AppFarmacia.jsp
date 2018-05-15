<%-- 
    Document   : AppFarmacia
    Created on : 30-abr-2018, 16:45:02
    Author     : yhoelfarfan
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <style>
        .table {
        border-radius: 5px;
        width: 50%;
        margin: 0px auto;
        float: none;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>           
    <script type="text/javascript">    
         var medicamento = null;
         function webServiceResult(data)
        {
            $("#DataTable").empty(); 
            var tabla = '<table  class="table table-striped" id="DataTable">';
              tabla += '<thead>';
              tabla += '<tr>';
                tabla += '<th>ID MEDICAMENTO</th><th>NOMBRE MEDICAMENTO</th>';
                tabla += '</tr>';
                tabla += '</thead>';
                tabla += '<tbody>';
                tr = '';
            $.each(data.result.records, function(i,item){  
                tr += '<tr>';
                    tr += '<td>'+item._id+'</td><td>'+item["Nombre Producto"]+'</td>';
                tr += '</tr>';     
            });       
              tabla += tr;
                tabla += '</tbody></table>';            
            $('#lista_medicamentos').html( tabla );
            
           
           
        }
          function webServiceResult2(data)
        {
          $("#DataTable2").empty(); 
            var tabla = '<table  class="table table-striped" id="DataTable2">';
              tabla += '<thead>';
              tabla += '<tr>';
                tabla += '<th>NOMBRE FARMACIA</th><th>TELEFONO</th><th>COMUNA</th><th>HORA APERTURA</th><th>HORA CIERRE</th>';
                tabla += '</tr>';
                tabla += '</thead>';
                tabla += '<tbody>';
                tr = '';
            $.each(data.result.records, function(i,item){              
                tr += '<tr>';
                    tr += '<td>'+item.local_nombre+'</td><td>'+item.local_telefono+'</td><td>'+item.comuna_nombre+'</td><td>'+item.funcionamiento_hora_apertura+'</td><td>'+item.funcionamiento_hora_cierre+'</td>';
                tr += '</tr>';     
            });       
              tabla += tr;
                tabla += '</tbody></table>';            
            $('#lista_farmacias2').html( tabla );
        }
        
        function callWebServiceMed()
        {        
            try
            {              
                medicamento = $('input:text[name=nombreMedicamento]').val();                         
                var data = {
                        resource_id: '8c8124ab-41ee-46c3-b967-c82a09bc592f', // the resource id
                        limit: 200, // get 5 results
                        q: medicamento // query for 'jones'
                    };
                $.ajaxSetup ({cache: true});
                $.ajax({
                    url: 'http://datos.gob.cl/api/action/datastore_search',
                    data: data,
                    dataType: 'jsonp',
                    success: function(msg){ webServiceResult(msg) },
                    error: function(jqXmlHttpRequest, textStatus, errorThrown) { alert("Error leyendo datos."); }

                 });
            } 
            catch (err) 
            {
              alert(err);
            }
        }
        function callWebServiceFar()
        {        
            try
            {              
                idFarmacia = $('input:text[name=idFarmacia]').val();
                 var data = {
                        resource_id: 'a60f93af-6a8a-45b6-85ff-267f5dd37ad6', // the resource id
                        limit: 200, // get 5 results
                        q: medicamento // query for 'jones'
                    };
                $.ajaxSetup ({cache: true});
                $.ajax({
                    url: 'http://datos.gob.cl/api/action/datastore_search_sql?sql=SELECT * from "a60f93af-6a8a-45b6-85ff-267f5dd37ad6" WHERE local_id='+idFarmacia+'',
                    data: data,
                    dataType: 'jsonp',
                    success: function(msg){ webServiceResult2(msg) },
                    error: function(jqXmlHttpRequest, textStatus, errorThrown) { alert("Error leyendo datos."); }

                 });
            } 
            catch (err) 
            {
              alert(err);
            }
        }
        
       
    </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmaceutica</title>
    </head>
    <body>   
    <div class="container">
    <a class="btn btn-success" href="MantenedorUsuario.jsp">Mantenedor de usuarios</a>
    <!--MEDICAMENTO-->
    <form name="form" action="" method="post">
        <br>
        <br>
        <div class="input-group input-group-sm mb-3">
            <input type="text" class="form-control" id="nombreMedicamento" name="nombreMedicamento" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
        </div>
        <button type="button" class="btn btn-primary btn-sm" id="btnMedicamento" name="btnMedicamento" onclick="javascript:callWebServiceMed();">Buscar Medicamento</button>
    </form>
        <br>
        <div id="lista_medicamentos"></div>
  
     <!--FARMACIA-->
     <form name="form2" action="" method="post">
        <br>
        <br>
        <div class="input-group input-group-sm mb-3">
            <input type="text" class="form-control" id="idFarmacia" name="idFarmacia" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
        </div>
        <button type="button" class="btn btn-primary btn-sm" id="btnFarmacia" name="btnFarmacia" onclick="javascript:callWebServiceFar();">Buscar Farmacia</button>
    </form>
        <br>
        <div id="lista_farmacias2"></div>
    </div>    
       
    </body>
</html>
