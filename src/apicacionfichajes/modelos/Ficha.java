/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.modelos;

import java.sql.Date;

/**
 *
 * @author adria
 */
public class Ficha {
    private int idEmpleado;
    private Date entrada;
    private Date salida;

    public Ficha() {}
    
    public Ficha(int idEmpleado, Date entrada, Date salida) {
        this.idEmpleado = idEmpleado;
        this.entrada = entrada;
        this.salida = salida;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    @Override
    public String toString() {
        return "Ficha" + "idEmpleado" + idEmpleado + ", entrada=" + entrada + ", salida=" + salida + '}';
    }
    
    
}
