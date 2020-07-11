/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.infoPersonaDao;
import Dao.infoProyectoDao;
import Dto.infoArchivoDto;
import Dao.infoArhivosDao;
import Dto.infoPersonaDto;
import Dto.infoProyectoDto;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author crist
 */
@WebServlet(name = "menu", urlPatterns = {"/menu"})
public class menu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("opcion");
            String namePr = request.getParameter("nombreP");
            String archivo = request.getParameter("arc");
            Runtime runtime = Runtime.getRuntime();
            switch (accion) {
                case "registro":
                    response.sendRedirect("formRegistro.jsp");
                    break;
                case "inicioU":
                    response.sendRedirect("inicioSesion.jsp");
                    break;
                case "insertarper":
                    infoPersonaDao depdao = new infoPersonaDao();
                    Object name = request.getParameter("nombre");
                    Object lastname = request.getParameter("apellido");
                    Object mail = request.getParameter("correo");
                    Object date = request.getParameter("fecha");
                    Object usuario = request.getParameter("usuario");
                    Object passwd = request.getParameter("pas");
                    Object namDB = request.getParameter("namedb");
                    Collection<infoPersonaDto> dt = depdao.insertarRegistro(name, lastname, mail, date, usuario, passwd, namDB);
                    response.sendRedirect("index.jsp");

                    break;
                case "proyectos":
                    response.sendRedirect("Proyectos.jsp");
                    break;
                case "inicio":
                    response.sendRedirect("bienvenida.jsp");
                    break;
                case "agregar":
                    response.sendRedirect("agregarProyecto.jsp");
                    break;
                case "proyecto":
                    try {
                        infoPersonaDto per = new infoPersonaDto();
                        infoProyectoDao pro = new infoProyectoDao();
                        infoProyectoDto dto = new infoProyectoDto();
                        Date myDate = new Date();
                        Object fecha = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
                        String nameP = request.getParameter("proye");
                        //se asigna valores al dto
                        dto.setId_usuario(per.getIdPersona());
                        dto.setUsuario(per.getUsuario());

                        dto.setNombreP(nameP);
                        Collection<infoProyectoDto> prodto = pro.insertarProyecto(per.getIdPersona(), per.getUsuario(), fecha, nameP);
                        try {
                            String cmd = "mkdir /var/www/html/ProyectosAlumnos/" + nameP; //Comando de apagado en linux
                            //String cmd2="chown -R  tomcat:apache /var/www/html/ProyectosAlumnos/"+nameP;
                            Runtime.getRuntime().exec(cmd);
                            response.sendRedirect("uploadFile.jsp?dr=1");
                        } catch (IOException ioe) {
                            System.out.println(ioe);
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "archivoG":
                    infoProyectoDto dto = new infoProyectoDto();

                    String archivourl = "var/www/html/ProyectosAlumnos/" + dto.getNombreP();
                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    factory.setSizeThreshold(1024);
                    factory.setRepository(new File(archivourl));
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    try {
                        List<FileItem> partes = upload.parseRequest(request);

                        for (FileItem items : partes) {
                            File file = new File(archivourl, items.getName());
                            items.write(file);
                            response.sendRedirect("uploadFile.jsp?dr=1");
                        }
                        out.print("<h2>ARCHIVO CORRECTAMENTE SUBIDO.....</h2>" + "\n\n" + "<a href='index.jsp'>VOVLER AL MENU</a>");

                    } catch (Exception e) {
                        out.print(dto.getNombreP());
                        out.print("Exception: " + e.getMessage() + "");
                    }
                    break;
                case "archivo":
                    infoArhivosDao dao = new infoArhivosDao();
                    infoProyectoDto dtoP = new infoProyectoDto();
                    String nameA = request.getParameter("archi");
                    Collection<infoArchivoDto> dtoa = dao.insertarArchivo(nameA, dtoP.getNombreP());
                    response.sendRedirect("uploadFile.jsp?dr=2");
                    break;
                case "abrirAr":
                    infoArhivosDao daoA = new infoArhivosDao();
                    infoProyectoDto dtoPr = new infoProyectoDto();
                    dtoPr.setNombreP(namePr);
                    response.sendRedirect("Archivos.jsp?nameP=" + namePr);
                    break;
                case "eliminar":
                    infoProyectoDao pro = new infoProyectoDao();
                   
                    try {
                         pro.eliminarProyecto(namePr);
                        String cmd = "rm -Rf /var/www/html/ProyectosAlumnos/" + namePr; //Comando de apagado en linux
                        //String cmd2="chown -R  tomcat:apache /var/www/html/ProyectosAlumnos/"+nameP;
                        Runtime.getRuntime().exec(cmd);
                        response.sendRedirect("Proyectos.jsp");
                    } catch (Exception e) {
                        out.print(e);
                    }

                    break;
                case "eliminarA":
                    infoArhivosDao daoa = new infoArhivosDao();
                    
                    try {
                        daoa.eliminarArchivo(archivo);
                        String cmd = "rm /var/www/html/ProyectosAlumnos/" + namePr + "/" + archivo; //Comando de apagado en linux
                        //String cmd2="chown -R  tomcat:apache /var/www/html/ProyectosAlumnos/"+nameP;
                        Runtime.getRuntime().exec(cmd);
                        response.sendRedirect("Archivos.jsp?nameP=" + namePr);
                    } catch (Exception e) {
                        out.print(e);
                    }   
                    break;
                case "agregarArchivo":
                    response.sendRedirect("uploadFile.jsp?dr=1");
                    break;
                case "info":
                    response.sendRedirect("Info.jsp");
                    break;
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
