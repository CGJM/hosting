<%-- 
    Document   : inicioSesion
    Created on : 27/10/2019, 06:07:49 PM
    Author     : crist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <title>Inicio de sesión</title>
    </head>
    <body style="background-color: #870922">
        <form  class="form-signin" method="post" action="Login?opcion=inicio" ><br><br>
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center;color:#FEFCFD;">Inicio sesión</h1>
            <h1  style="text-align: center; color:#FEFCFD;">Autentificación de usuario</h1>
            <br>
            <div class="container col-md-3" style="color:#FEFCFD;">
               
                Usuario:<input type="text"  class="form-control" name="user" placeholder="Pedro1"></input>
                <br>
                Contraseña:<input type="password"  class="form-control"  name="password"></input>
                <br>
               
                <input type="submit" class="btn btn-lg  btn-block" style="color:#FEFCFD; background: #c59400" value="ingresar"/>
            </div>

        </form>
    </body>
</html>
