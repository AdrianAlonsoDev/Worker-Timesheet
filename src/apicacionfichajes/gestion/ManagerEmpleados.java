/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.gestion;

import apicacionfichajes.modelos.Empleado;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class ManagerEmpleados {
    
    private ArrayList<Empleado> listaEmpl;
    
    public ManagerEmpleados() {
        listaEmpl = new ArrayList<Empleado>();
    }
    public boolean add(Empleado empl) {       
        return listaEmpl.add(empl);
    }
    
    public boolean remove(Empleado empl) {
        return listaEmpl.remove(empl);
    }

    public Empleado get(int pos) {
        return listaEmpl.get(pos);
    }
    
    public int size(){
        return listaEmpl.size();
    }
    
    /**
     * buscarDeparatamento method. 
     * @param nombre
     * @return Departamento if found. if not return a null dept.
     */
    public Empleado buscar(String nombre) {
        
        Empleado empl = null;

        for (int i = 0; i < listaEmpl.size(); i++) {
            if(listaEmpl.get(i).getNombre().equals(nombre)) {
                empl = listaEmpl.get(i);
            }
        }
        if(empl == null) {
            System.out.println("El departamento no se encontró");
        }
        return empl;
    }
    
    public Empleado buscar(int id) {
        
        Empleado empl = null;
        
        for (int i = 0; i < listaEmpl.size(); i++) {
            if(listaEmpl.get(i).getId() == id) {
                empl = listaEmpl.get(i);
            } else {
                System.out.println("Empleado no encontrado");
            }
        }
        return empl;
    }
    
    public Empleado loggedUser(Empleado emp){
        return emp;
    } 

    @Override
    public String toString() {
        return "ManagerEmpleados: Lista de Empleados: " + listaEmpl;
    }
}
