/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.db;

import apicacionfichajes.ManagerEmpleados;
import apicacionfichajes.modelos.Empleado;
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
public class GestionEmpleado_old {

    GestionDBConn GDB = GestionDBConn.getInstance();
    ManagerEmpleados ME = new ManagerEmpleados();

    private void conectar() {
        GDB.conectar();
    }

    private void desconectar() {
        GDB.desconectar();
    }

    public boolean insertarEmpleado(Empleado emp) {
        boolean insertar = false;

        conectar();

        try {
            Statement sentence = GDB.conn.createStatement();
            String sql = String.format("INSERT INTO empleados (nombre,apellidos,codigo,total_horas) VALUES ('%s','%s',%s,%s)",
                    emp.getNombre(), emp.getApellidos(), emp.getCodigo(), emp.getTotal_horas());
            insertar = sentence.execute(sql);
            sentence.close();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GestionEmpleado_old.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertar;
    }

    //Borrar empleado
    public boolean eliminarEmpleado(Empleado emp) {
        boolean resultadoEliminar = false;
        conectar();
        try {
            Statement sentencia = GDB.conn.createStatement();
            //Preparar la sentencia SQL
            String sql = String.format("DELETE FROM empresa.empleados WHERE id = (%s)", emp.getId());
            //Ejecutamos la sentencia
            resultadoEliminar = sentencia.execute(sql);
            //Cerramos conexiones
            sentencia.close();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GestionEmpleado_old.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoEliminar;
    }

    public boolean modificarEmpleado(Empleado emp) {
        boolean resultadoModificar = true;
        conectar();
        try {
            Statement sentencia = GDB.conn.createStatement();
            //Preparar la sentencia SQL
            String sql = String.format("UPDATE empresa.empleados SET nombre=('%s'), apellidos=('%s'), codigo=(%s), total_horas=(%s) WHERE id = (%s)",
                    emp.getNombre(), emp.getApellidos(), emp.getCodigo(), emp.getTotal_horas(), emp.getId());
            //Ejecutamos la sentencia
            resultadoModificar = sentencia.execute(sql);
            //Cerramos conexiones
            sentencia.close();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GestionEmpleado_old.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultadoModificar;
    }

    public ManagerEmpleados listarEmpleados() {
        ManagerEmpleados listado = ME;
        ResultSet rs;
        //Conectar con la base de datos
        conectar();

        //Enviar la modificacion a la base de datos
        try {
            //Creamos la sentencia
            Statement sentence = GDB.conn.createStatement();
            // Y la syntax de la sentencia
            String sql = "SELECT * FROM empleados";
            //Ejecutar la consulta
            sentence.execute(sql);
            //Obtengo el resultset
            rs = sentence.getResultSet();

            while (rs.next()) {
                listado.add(new Empleado(rs.getInt(1),
                                         rs.getString(2),
                                         rs.getString(3),
                                         rs.getInt(4), 
                                         rs.getDouble(5)));
            }

            rs.close();
            sentence.close();
            desconectar();

        } catch (SQLException ex) {
            Logger.getLogger(GestionDBConn.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listado;
    }

    public ManagerEmpleados manager() {
        return ME;
    }

}
