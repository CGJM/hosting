/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author crist
 */
public class infoArchivoDto {
    private static String nombreA;
    private static String nombreP;

    @Override
    public String toString() {
        return "infoArchivoDto{" + '}';
    }

    public static String getNombreA() {
        return nombreA;
    }

    public static void setNombreA(String nombreA) {
        infoArchivoDto.nombreA = nombreA;
    }

    public static String getNombreP() {
        return nombreP;
    }

    public static void setNombreP(String nombreP) {
        infoArchivoDto.nombreP = nombreP;
    }
}
