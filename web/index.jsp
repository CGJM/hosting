<%-- 
    Document   : index
    Created on : 27/10/2019, 11:48:54 AM
    Author     : crist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sitio web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="carruselEstilo.css">
        <link rel="stylesheet" href="estiloNavBar.css">
    </head>
    <body style="background-color: #870922">
        <div>
            <h1 style="text-align: center; color:#FEFCFD; margin-top: 60px">Bienvenido al sitio web UPT Alumnos </h1>
        </div>
        <div class="wrap">
            <span class="decor"></span>
            <nav>
                <ul class="primary">
                    <li>
                        <a href="menu?opcion=registro">Registrarse</a>
                    </li>
                    <li>
                        <a href="">Iniciar sesión</a>
                        <ul class="sub">
                            <li><a href="">Administrador</a></li>
                            <li><a href="menu?opcion=inicioU">Usuario</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="">Acerca de</a>
                        <ul class="sub">
                            <li><a href="Manual de usuario webhosting UPT.pdf" target="blank">Manual de usaurio</a></li>
                            <li><a href="menu?opcion=info">Desarrolladores y contacto</a></li>
                        </ul>  
                    </li>
                </ul>
            </nav>
        </div>  
        <br><br><br>
        <div class="content-all">
            <div class="content-carrousel">
                <figure><img src="https://www.hidalguia.com.mx/gobierno/2014/140410-0430.jpg"></figure>
                <figure><img src="http://www.upt.edu.mx/Contenido/OfertaEducativa/Profesional/ISC/images/ing_sistemas_01.jpg"></figure>
                <figure><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRZ4svmOGvbWKZaPzquWWGj9TIJmnOPnJzql5K_jCTKQLokUINo"></figure>
                <figure><img src="http://www.upt.edu.mx/Contenido/OfertaEducativa/Profesional/ISC/images/Galeria/img_ISC_1.jpg"></figure>
                <figure><img src="http://www.upt.edu.mx/Contenido/OfertaEducativa/Profesional/ISC/images/Galeria/img_ISC_4.jpg"></figure>
                <figure><img src="http://www.upt.edu.mx/Contenido/OfertaEducativa/Profesional/ISC/images/Galeria/img_ISC_5.jpg"></figure>
                <figure><img src="http://www.upt.edu.mx/Contenido/OfertaEducativa/Profesional/ISC/images/Galeria/img_ISC_11.jpg"></figure>
                <figure><img src="http://www.upt.edu.mx/Contenido/OfertaEducativa/Profesional/ISC/images/Galeria/img_ISC_12.jpg"></figure>
                <figure><img src="http://www.upt.edu.mx/Contenido/OfertaEducativa/Profesional/ISC/images/Galeria/img_ISC_13.jpg"></figure>
                
            </div>

        </div>

    </body>
</html>
