<%-- 
    Document   : Archivos
    Created on : 24/11/2019, 01:38:36 AM
    Author     : crist
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Dto.infoPersonaDto"%>
<%@page import="Dao.infoArhivosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
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
        <% String name=request.getParameter("nameP");%>
        <title>Archivos del proyecto</title>
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
        <div style="margin-left:43%;padding:1px 16px;height:100px;">
            <h1>Archivos de proyecto</h1>
            <br><br><br><br>
        </div >
        <div style="margin-left:73%;padding:1px 16px;height:100px;">
            <a href="menu?opcion=agregarArchivo"><button type="submit" class="btn btn-info btn-block">Agregar</button></a>
            <br><br><br><br>
        </div >
        <div style="margin-left:17%;padding:1px 16px;">
            <table class="table" >
                <thead style="background-color: #870922">
                    <tr style=" color:#FEFCFD;">
                        <th scope="col">Nombre de proyecto</th>
                        <th scope="col">Nombre de archivo</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <%
                    
                    infoArhivosDao dao = new infoArhivosDao();
                    ResultSet tab = dao.tablaArchivos(name);
                    try {
                        while (tab.next()) {
                %>
                <tbody>
                    <tr>
                        <th scope="row"><%= tab.getString("NombreProyecto") %></th>
                        <td><%= tab.getString("nombreArchivo") %></td>
                        <td>
                            <a href="menu?opcion=eliminarA&nombreP=<%=tab.getString("NombreProyecto") %>&arc=<%=tab.getString("nombreArchivo") %>" class="btn btn-danger">Eliminar</a>
                        </td>
                    </tr>

                </tbody>
                <%
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                %>


            </table>
        </div> 
        <%
            } else {
                response.sendRedirect("inicioSesion.jsp");
            }
        %>
        
    </body>
</html>
