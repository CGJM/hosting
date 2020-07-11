<%-- 
    Document   : uploadFile
    Created on : 23/11/2019, 11:35:23 PM
    Author     : crist
--%>

<%@page import="Dto.infoPersonaDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Subir archivos</title>
    </head>
    <body>
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
        <div style="margin-left:46%;padding:1px 16px;">
            <h1>Proyecto generado</h1>
            <h3>Generar archivos</h3>
        </div>
        <br>
        <br>
        <% 
            String acci = request.getParameter("dr");
        %>
        <div class="container mt-4 col-lg-4"style="margin-left:42%;padding:1px 16px;">
            <div class="card col-sm-12" style="background-color: #F7FAFC">
                <div class="card-body" >
                    <% if(acci.equals("1")){%>
                    <form action="menu?opcion=archivo" method="POST">
                        Nombre del archivo<br><input type="text"  class="form-control" name="archi">
                        <br>
                        <input type="submit" class="btn btn-danger  btn-block" value="Guardar" >
                    </form>
                    <% }else{%>
                    <br>
                    <form action="menu?opcion=archivoG"  method="post" enctype="multipart/form-data">
                        <table>
                            <tr>
                                <td>
                                    <input type="file"  name="file" accept=".php,.html"/>
                                    <br>
                                    <br>
                                    <input type="submit" class="btn btn-danger  btn-block" value="Guardar" > 
                                </td>
                            </tr>
                        </table>
                    </form>
                    <% }%>
                </div>
            </div>
        </div>
        <%
            } else {
                response.sendRedirect("inicioSesion.jsp");
            }
        %>
    </body>
</html>
