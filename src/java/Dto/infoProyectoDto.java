 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.util.Date;

/**
 *
 * @author crist
 */
public class infoProyectoDto {
    private static int id_usuario;
    private static String usuario;
    private static Date fecha;
    private static String nombreP;

    public static int getId_usuario() {
        return id_usuario;
    }

    @Override
    public String toString() {
        return "infoProyectoDto{" + '}';
    }

    public static void setId_usuario(int id_usuario) {
        infoProyectoDto.id_usuario = id_usuario;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        infoProyectoDto.usuario = usuario;
    }

    public static Date getFecha() {
        return fecha;
    }

    public static void setFecha(Date fecha) {
        infoProyectoDto.fecha = fecha;
    }

    public static String getNombreP() {
        return nombreP;
    }

    public static void setNombreP(String nombreP) {
        infoProyectoDto.nombreP = nombreP;
    }
    
    
    
    
}
