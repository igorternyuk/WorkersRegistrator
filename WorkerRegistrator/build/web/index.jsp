<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Início Sesíon</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Início de sesíon</h1>
        <form action = "validate.do" method = "post">
            <input type = "email" name = "txtMail" placeholder="E-mail" required="required" style="font-size: 20px"/><br/><br/>
            <input type="password" name = "txtPass" placeholder = "contrasena" required="required" style="font-size: 20px"/><br/><br/>
            <input type="submit" value="Iniciar secion" style="font-size: 20px"/>
        </form>
    </body>
</html>
