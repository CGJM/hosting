/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.infoArchivoDto;
import Dto.infoPersonaDto;
import Dto.infoProyectoDto;
import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class infoArhivosDao {
    Vector<infoArchivoDto> vet;

    public Collection<infoArchivoDto> insertarArchivo(Object nombreA, Object nombreP) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnecion();
            String sql = "call `insertarArchivo`(?,?);";
            pstm = con.prepareStatement(sql);
            pstm.setObject(1, nombreA);
            pstm.setObject(2, nombreP);
            pstm.executeUpdate();
            vet = new Vector<infoArchivoDto>();
            infoPersonaDto objDto;
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return vet;

    }
    
     public Collection<infoArchivoDto> eliminarArchivo(Object nombreP) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnecion();
            String sql ="delete from info_Archivos where nombreArchivo='"+nombreP+"';";
            pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            vet = new Vector<infoArchivoDto>();
            infoPersonaDto objDto;
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return vet;

    }
    public ResultSet tablaArchivos(String nombreP) {
        Connection con=Conexion.getConnecion();
        ResultSet resultado = null;
        try {
            String instruccion = "select*from info_Archivos where NombreProyecto='"+nombreP+"';";
            Statement stmt = con.createStatement();
            resultado = stmt.executeQuery(instruccion);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return resultado;
    }
}
