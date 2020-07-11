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
public class infoPersonaDto {

    private static int idPersona;
    private static String nombre;
    private static String apellido;
    private static String correo;
    private static String usuario;
    private static String contraseña;
    private static Date fechaNac;

    @Override
    public String toString() {
        return "infoPersonaDto{" + '}';
    }

    public static int getIdPersona() {
        return idPersona;
    }

    public static void setIdPersona(int idPersona) {
        infoPersonaDto.idPersona = idPersona;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        infoPersonaDto.nombre = nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        infoPersonaDto.apellido = apellido;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        infoPersonaDto.correo = correo;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        infoPersonaDto.usuario = usuario;
    }

    public static String getContraseña() {
        return contraseña;
    }

    public static void setContraseña(String contraseña) {
        infoPersonaDto.contraseña = contraseña;
    }

    public static Date getFechaNac() {
        return fechaNac;
    }

    public static void setFechaNac(Date fechaNac) {
        infoPersonaDto.fechaNac = fechaNac;
    }

    public void limpiar() {
        idPersona = 0;
        nombre=null;
        apellido=null;
        correo=null;
        usuario=null;
        contraseña=null;
        fechaNac=null;
        System.out.println("Limpio");
    }

}
