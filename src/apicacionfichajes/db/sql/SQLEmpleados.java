/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.db.sql;

import apicacionfichajes.gestion.ManagerEmpleados;
import apicacionfichajes.db.GestionDBConn;
import apicacionfichajes.gestion.GestionHelper;
import apicacionfichajes.modelos.Empleado;
import apicacionfichajes.modelos.DebugManager;
import apicacionfichajes.modelos.QType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author adria
 */
public class SQLEmpleados {

    final GestionDBConn GDB = GestionDBConn.getInstance();
    final DebugManager logger = new DebugManager(true);

    private void conectar() {
        GDB.conectar();
    }

    private void desconectar() {
        GDB.desconectar();
    }
    
    public boolean empleadoQuery(Empleado emp, QType type, Empleado EmpModified) {
        boolean resultadoQuery = false;
        boolean logged = false;
        conectar();

        try {
            logger.debug("Intentando ejecutar query de Empleados...");
            Statement sentence = GDB.conn.createStatement();
            String sql;
            ResultSet rs;
            switch(type) {
                case NEW:
                    sql = String.format("INSERT INTO empleados (nombre,apellidos,codigo,total_horas) VALUES ('%s','%s',%s,%s)",
                    emp.getNombre(), emp.getApellidos(), emp.getCodigo(), emp.getTotal_horas());
                    resultadoQuery = sentence.execute(sql);                 
                    break;
                case DELETE:
                    sql = String.format("DELETE FROM empleados WHERE id = (%s)", emp.getId());
                    resultadoQuery = sentence.execute(sql);
                    break;
                case MODIFY:
                    sql = String.format("UPDATE empleados SET nombre=('%s'), apellidos=('%s'), codigo=(%s), total_horas=(%s) WHERE id = (%s)",
                    EmpModified.getNombre(), EmpModified.getApellidos(), EmpModified.getCodigo(), EmpModified.getTotal_horas(), EmpModified.getId());
                    resultadoQuery = sentence.execute(sql);
                    break;
                case LOGIN:
                    
                    sql = "SELECT COUNT(*) FROM empleados WHERE id =" + emp.getId() + " and codigo =" + EmpModified.getCodigo();
                    rs = sentence.executeQuery(sql);
                    rs = sentence.getResultSet();
                    
                    while(rs.next()) {
                        int codigo = rs.getInt(1);
                        
                        if(codigo == 1) {
                            logged = true;                          
                        }
                    } 
                    break;
            }            
            sentence.close();
            desconectar();
            return logged;
        } catch (SQLException ex) {
            logger.error("Error al ejecutar query (SQLException) ->");
            Logger.getLogger(SQLEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultadoQuery;
    }

    public ManagerEmpleados listarEmpleados() {
        ManagerEmpleados listado = new ManagerEmpleados();
        ResultSet rs;
        conectar();

        try {
            logger.debug("ListarEmpleados: \n Intentando listar empleados.");
            Statement sentence = GDB.conn.createStatement();
            String sql = "SELECT * FROM empleados";
            sentence.execute(sql);
            rs = sentence.getResultSet();

            while (rs.next()) {
                listado.add(new Empleado(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getDouble(5)));
            }

            rs.close();
            sentence.close();
            desconectar();

        } catch (SQLException ex) {
            logger.error("ListarEmpleados: \n Empleados no listados.");
            Logger.getLogger(GestionDBConn.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listado;
    }

}
