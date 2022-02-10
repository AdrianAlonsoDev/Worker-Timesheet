/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.gestion;

import apicacionfichajes.modelos.Empleado;
import apicacionfichajes.modelos.Ficha;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class ManagerFichas {
    
    private ArrayList<Ficha> listaFicha;
    
    public ManagerFichas() {
        listaFicha = new ArrayList<Ficha>();
    }
    public boolean add(Ficha ficha) {       
        return listaFicha.add(ficha);
    }
    
    public boolean remove(Ficha ficha) {
        return listaFicha.remove(ficha);
    }

    public Ficha get(int pos) {
        return listaFicha.get(pos);
    }
    
    public int size(){
        return listaFicha.size();
    }
    
    
    public Ficha buscar(int id) {
        
        Ficha ficha = null;
        
        for (int i = 0; i < listaFicha.size(); i++) {
            if(listaFicha.get(i).getIdEmpleado() == id) {
                ficha = listaFicha.get(i);
            } else {
                System.out.println("Ficha ("+ id+") no encontrada");
            }
        }
        return ficha;
    }

    @Override
    public String toString() {
        return "ManagerFichas{" + "listaFicha=" + listaFicha + '}';
    }
}
