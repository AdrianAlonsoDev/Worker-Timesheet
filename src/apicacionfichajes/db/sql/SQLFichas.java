/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.db.sql;

import apicacionfichajes.gestion.ManagerEmpleados;
import apicacionfichajes.gestion.ManagerFichas;
import apicacionfichajes.db.GestionDBConn;
import apicacionfichajes.modelos.Empleado;
import apicacionfichajes.modelos.DebugManager;
import apicacionfichajes.modelos.Ficha;
import apicacionfichajes.modelos.QType;
import apicacionfichajes.modelos.QType.FType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adria
 */
public class SQLFichas {

    final GestionDBConn GDB = GestionDBConn.getInstance();
    ManagerFichas listado = new ManagerFichas();
    final DebugManager logger = new DebugManager(true);
    boolean resultadoQuery;
    
    private void conectar() {
        GDB.conectar();
    }

    private void desconectar() {
        GDB.desconectar();
    }   
    
    public void fichaQuery(Empleado empl, FType type) {
        conectar();
        try {
            logger.debug("Intentando ejecutar query de Fichas...");
            Statement sentence = GDB.conn.createStatement();
            String sql;
            ResultSet rs;
            switch(type) {
                case ENTRADA:
                    sql = String.format("SELECT empleado_id FROM fichas WHERE empleado_id = %s and salida is null",
                    empl.getId());
                    sentence.execute(sql);
                    rs = sentence.getResultSet();

                    if(!(rs.next())){
                        sql = String.format("INSERT INTO fichas (empleado_id,entrada,salida) VALUES ("+ empl.getId() +",now(),null)");
                        resultadoQuery = sentence.execute(sql); 
                    }                                
                    break; 
                case SALIDA:
                    sql = String.format("UPDATE fichas SET salida=now() WHERE empleado_id = (%s)",
                    empl.getId());
                    //Ejecutamos la sentencia
                    resultadoQuery = sentence.execute(sql);
                    break;
            }            
            sentence.close();
            desconectar();
        } catch (SQLException ex) {
            logger.error("Error al ejecutar query (SQLException) ->");
            Logger.getLogger(SQLFichas.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    public ManagerFichas listarFichas() {
        ManagerFichas listado = new ManagerFichas();
        ResultSet rs;
        
        conectar();

        
        try {
            logger.debug("ListarFichas: \n listando fichas.");
            
            Statement sentence = GDB.conn.createStatement();
            
            String sql = "SELECT * FROM fichas";
            
            sentence.execute(sql);
            
            rs = sentence.getResultSet();

            while (rs.next()) {
                listado.add(new Ficha(rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3)));
            }

            rs.close();
            sentence.close();
            desconectar();

        } catch (SQLException ex) {
            logger.error("ListarFichas: \n Fichas no listadas.");
            Logger.getLogger(GestionDBConn.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listado;
    }

}
