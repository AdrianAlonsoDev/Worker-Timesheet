/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adria
 */
public class GestionDBConn {

    public static GestionDBConn getInstance() {
        GestionDBConn GDB = new GestionDBConn("userdb","1234","localhost","fichajes");
        return GDB;
    }
    
    private String user;
    private String password;
    private String host;
    private String db;
    public Connection conn;

    public GestionDBConn() {
    }

    public GestionDBConn(String user, String password, String host, String db) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.db = db;
    }
 
    public boolean conectar() {
        boolean resultado = true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://" + host + "/fichajes", user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestionDBConn.class.getName()).log(Level.SEVERE, null, ex);
            resultado = false;
        } return resultado;
    }

    public boolean desconectar() {
        boolean resultado = true;
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDBConn.class.getName()).log(Level.SEVERE, null, ex);

        } return resultado;
    }
    
    public Connection getConexion() {
        return conn;
    }
}
