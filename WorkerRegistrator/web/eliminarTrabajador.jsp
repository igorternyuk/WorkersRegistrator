<%-- 
    Document   : eliminarTrabajador
    Created on : Apr 21, 2017, 1:48:40 PM
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminacíon de informacíon de trabajadores</h1>
        <form action="eliminar.do" method="post">
        <input type = "text" name = "txtID" placeholder="id" required="required" style="font-size: 20px"/>
        <input type="submit" value="Eliminar" style="font-size: 20px"/>    
        </form>        
        <a href="menu.view">Volver al menú</a>
    </body>
</html>
