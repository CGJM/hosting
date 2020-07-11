/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.Vector;
import Dto.infoPersonaDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import Dto.infoPersonaDto;
import Model.Conexion;

/**
 *
 * @author crist
 */
public class infoPersonaDao {

    Vector<infoPersonaDto> vet;

    public Collection<infoPersonaDto> insertarRegistro(Object nombre, Object apellido, Object correo, Object fec, Object usu, Object pass,Object databaseName) {
        Connection con = null;
        PreparedStatement pstm = null,pstm1=null,pstm2=null,pstm3=null,pstm4=null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnecion();
            String sql = "call `insertarPersona`(?,?,?,?,?,?);";
            String sql1="create database "+databaseName+"; ";
            String sql2="CREATE USER '"+usu+"'@'localhost' IDENTIFIED BY '"+pass+"';";
            String sql3="GRANT ALL PRIVILEGES ON "+databaseName+".* TO '"+usu+"'@'localhost';";
            String sql4="FLUSH PRIVILEGES;";
            pstm = con.prepareStatement(sql);
            pstm1=con.prepareStatement(sql1);
            pstm2=con.prepareStatement(sql2);
            pstm3=con.prepareStatement(sql3);
            pstm4=con.prepareStatement(sql4);
            pstm.setObject(1, nombre);
            pstm.setObject(2, apellido);
            pstm.setObject(3, correo);
            pstm.setObject(4, fec);
            pstm.setObject(5, usu);
            pstm.setObject(6, pass);
            pstm.executeUpdate();
            pstm1.execute();
            pstm2.execute();
            pstm3.execute();
            pstm4.execute();
            vet = new Vector<infoPersonaDto>();
            infoPersonaDto objDto;
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return vet;

    }
    public  Collection<infoPersonaDto> autenticacion(Object user,Object pass) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnecion();
            String sql = "call `logeo`(?,?);";
            pstm = con.prepareStatement(sql);
            pstm.setObject(1, user);
            pstm.setObject(2, pass);
            rs = pstm.executeQuery();
            vet = new Vector<infoPersonaDto>();
            infoPersonaDto objDto;
            if (rs.next()) {
                System.out.println("Apellido "+rs.getString(2));
                objDto=new infoPersonaDto();
                objDto.setIdPersona(rs.getInt(1));
                objDto.setNombre(rs.getString(2));
                objDto.setApellido(rs.getString(3));
                objDto.setCorreo(rs.getString(4));
                objDto.setFechaNac(rs.getDate(5));
                objDto.setUsuario(rs.getString(6));
                objDto.setContraseña(rs.getString(7));
            }
            else{
                rs.close();
                pstm.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return vet;

    }
}
