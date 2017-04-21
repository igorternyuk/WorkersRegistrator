<%-- 
    Document   : editarInfoTrabajador
    Created on : Apr 21, 2017, 1:49:26 PM
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar la informacíon del trabajador</title>
    </head>
    <body>
        <h1>Editar la informacíon del trabajador</h1>
        <form action="editar.do" method="post">
        <input type="text" name = "txtID" placeholder = "id" required="required" style="font-size: 20px"/><br/><br/>
        <input type="text" name = "txtNombre" placeholder = "nombre" required="required" style="font-size: 20px"/><br/><br/>
        <input type="text" name="txtApeP" placeholder = "apellido patreno" required="required" style="font-size: 20px"><br/><br/>
        <input type="text" name="txtApeM" placeholder = "apellido matreno" style="font-size: 20px"><br/><br/>
        $<input type="number" name="txtSueldoBase" placeholder="sueldo base" style="font-size: 20px"><br/><br/>
        <input type="submit" value="Editar" style="font-size: 20px"/>    
        </form>        
        <a href="menu.view">Volver al menú</a>
    </body>
</html>
