/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crist
 */
public class Conexion {

    private static Connection con = null;

    public static Connection getConnecion() {

        try {
            String user = "root";
            String url = "jdbc:mysql://localhost/sitio?serverTimezone=UTC&useSSL=false";
            String password = "Esnafer19";
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException e){
            out.print(""+e);
        }
        return con;
    }
}
