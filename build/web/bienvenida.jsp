<%-- 
    Document   : bienvenida
    Created on : 31/10/2019, 11:43:41 PM
    Author     : crist
--%>

<%@page import="Dto.infoPersonaDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
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
        <style>
            body {
                margin: 0;
            }

            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                width: 17%;
                background-color: #870922;
                position: fixed;
                height: 100%;
                overflow: auto;
            }

            li a {
                display: block;
                color: #000;
                padding: 8px 16px;
                text-decoration: none;
            }

            li a.active {
                background-color: #4CAF50;
                color: white;
            }

            li a:hover:not(.active) {
                background-color: #B3A003;
                color: white;
            }
        </style>
        <% infoPersonaDto dto = new infoPersonaDto(); %>
        <title>UPT rest</title>
    </head>
    <body >
        <%
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("usuario") != null) {
                %>
                
           

        <ul>
            <li><h3 style="text-align: center; color:#FEFCFD;">Menu </h3></li>
            <li><a style="color:#FEFCFD;" href="menu?opcion=proyectos">Proyectos</a></li>
            <li><a style="color:#FEFCFD;" href="menu?opcion=agregar">Nuevo proyecto</a></li>
            <li><a style="color:#FEFCFD;" href="menu?opcion=inicio">Inicio</a></li>
            <li><a style="color:#FEFCFD;" href="http://187.141.55.141:10580/phpmyadmin/index.php" target="blank">MYSQL</a></li>
            <li><a style="color:#FEFCFD;" href="Login?opcion=log">Cerrar sesión</a></li>
            <li><a style="color:#FEFCFD;">Bienvenido: <%= dto.getNombre()%></a></li>
        </ul>
        <div style="margin-left:40%;padding:1px 16px;height:1000px;">
            <h1>Sistema de proyectos UPT</h1>
            <br><br><br><br>
            <img src="<%=request.getContextPath()%>\logo.png">
        </div>
             <%
            } else {
                response.sendRedirect("inicioSesion.jsp");
            }
        %>
    </body>
</html>
