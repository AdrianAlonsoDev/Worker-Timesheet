/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package apicacionfichajes;

import apicacionfichajes.gestion.GestionHelper;
import apicacionfichajes.modelos.Empleado;


/**
 *
 * @author adria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    GestionHelper GE = new GestionHelper();
    
//    
      Empleado newEmp = new Empleado(0, "Jose", "Lopez",  4321, 0);
//    
        GE.listarEmpleados();
        GE.insertarEmpleado(newEmp);
    
       
    }
}
