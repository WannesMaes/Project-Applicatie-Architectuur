<%-- 
    Document   : login
    Created on : 13-nov-2019, 13:43:10
    Author     : Wannes en Leen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Login </title>
    </head>
    <body>
        <h1>Hier inloggen</h1>
        Hallo, dit is de login pagina. <br/>
        Je weet wel hoe het werkt, hé.<br/>
        <form method="post" action="j_security_check">
            Gebruikersnaam: <input type="text" name="j_username"/>
            Paswoord: <input type="password" name="j_password"/><br/>
            <input type="submit" name="knop" value="Login"/>
        </form>
    </body>
</html>
