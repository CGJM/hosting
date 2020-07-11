/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.infoPersonaDto;
import Dto.infoProyectoDto;
import Model.Conexion;
import static java.lang.System.out;
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
public class infoProyectoDao {

    Vector<infoProyectoDto> vet;

    public Collection<infoProyectoDto> insertarProyecto(Object nombre, Object usuario, Object fec, Object nombreP) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnecion();
            String sql = "call `insertarProyecto`(?,?,?,?);";
            pstm = con.prepareStatement(sql);
            pstm.setObject(1, nombre);
            pstm.setObject(2, usuario);
            pstm.setObject(3, fec);
            pstm.setObject(4, nombreP);
            pstm.executeUpdate();
            vet = new Vector<infoProyectoDto>();
            infoPersonaDto objDto;
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return vet;

    }

    public Collection<infoProyectoDto> eliminarProyecto(Object nombreP) {
        Connection con = null;
        PreparedStatement pstm = null, pstm2 = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnecion();
            String sql = "delete from info_Archivos where NombreProyecto='" + nombreP + "';";
            String sql2 = "delete from info_Proyecto where NombreProyecto='" + nombreP + "';";
            pstm = con.prepareStatement(sql);
            pstm2 = con.prepareStatement(sql2);
            pstm.executeUpdate();
            pstm2.executeUpdate();
            vet = new Vector<infoProyectoDto>();
            infoPersonaDto objDto;
        } catch (SQLException ex) {
            out.print(ex);
        }
        return vet;

    }

    public ResultSet tablaProyectos() {
        infoProyectoDto dto=new infoProyectoDto();
        Connection con = Conexion.getConnecion();
        ResultSet resultado = null;
        try {
            String instruccion = "select*from info_Proyecto where Usuario='"+dto.getUsuario()+"';";
            Statement stmt = con.createStatement();
            resultado = stmt.executeQuery(instruccion);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return resultado;
    }

}
