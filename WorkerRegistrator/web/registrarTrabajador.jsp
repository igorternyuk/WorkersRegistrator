<%-- 
    Document   : registrarTrabajador
    Created on : Apr 20, 2017, 3:06:15 PM
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registracíon de trabajadores</title>
    </head>
    <body>
        <h1>Registracíon de trabajadores</h1>
        <form action="registrar.do" method="post">
        <input type = "text" name = "txtRut" placeholder="rut" required="required" style="font-size: 20px"/><br/><br/>
        <input type="text" name = "txtNombre" placeholder = "nombre" required="required" style="font-size: 20px"/><br/><br/>
        <input type="text" name="txtApeP" placeholder = "apellido patreno" required="required" style="font-size: 20px"><br/><br/>
        <input type="text" name="txtApeM" placeholder = "apellido matreno" style="font-size: 20px"><br/><br/>
        $<input type="number" name="txtSueldoBase" placeholder="sueldo base" style="font-size: 20px"><br/><br/>
        <input type="submit" value="Registrar" style="font-size: 20px"/>    
        </form>        
        <a href="menu.view">Volver al menú</a>
    </body>
</html>
