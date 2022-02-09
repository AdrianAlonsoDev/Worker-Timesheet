/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.gestionsql;

import apicacionfichajes.ManagerEmpleados;
import apicacionfichajes.ManagerFichas;
import apicacionfichajes.modelos.Empleado;
import apicacionfichajes.modelos.Ficha;
import apicacionfichajes.modelos.QType;

/**
 *
 * @author adria
 */
public class GestionHelper {
    
    SQLEmpleados SQLE = new SQLEmpleados();
    
    public boolean insertarEmpleado(Empleado emp) {
        return SQLE.empleadoQuery(emp, QType.NEW, null);
    }

    public boolean eliminarEmpleado(Empleado emp) {
        return SQLE.empleadoQuery(emp, QType.DELETE, null);
    }

    public boolean modificarEmpleado(Empleado emp, Empleado empModified) {
        return SQLE.empleadoQuery(emp, QType.MODIFY, empModified);
    }
    
    public boolean logearEmpleado(Empleado emp, Empleado empPass) {
        return SQLE.empleadoQuery(emp, QType.LOGIN, empPass);
    }
    
    public ManagerEmpleados listarEmpleados() { return SQLE.listarEmpleados();}
    
    
    SQLFichas SQLF = new SQLFichas();
    
    public void insertarEntrada(Empleado emp) {
        SQLF.fichaQuery(emp, QType.FType.ENTRADA);
    }

    public void eliminarSalida(Empleado emp) {
        SQLF.fichaQuery(emp, QType.FType.SALIDA);
    }
    
    public ManagerFichas listarFichas() { return SQLF.listarFichas(); }
    
}
