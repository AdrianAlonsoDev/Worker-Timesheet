/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apicacionfichajes.modelos;

/**
 *
 * @author adria
 */
public class Empleado {
    private int id;
    private String nombre;
    private String apellidos;
    private int codigo;
    private double total_horas;
    
    public Empleado() {
        this.id = 0;
        this.nombre = "";
        this.apellidos = "";
        this.codigo = 0;
        this.total_horas = 0;
    }
    
    public Empleado(int id, String nombre, String apellidos, int codigo, double total_horas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.total_horas = total_horas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getTotal_horas() {
        return total_horas;
    }

    public void setTotal_horas(double total_horas) {
        this.total_horas = total_horas;
    }   

    public String toSimpleString() {
        String empleado = nombre + " " + apellidos;
        return empleado;
    }
    
    @Override
    public String toString() {
        String empleado = "\n" + nombre + "\n" + apellidos + " \n" + codigo + " \n" + total_horas;

        return empleado;
    }
    
    
    
}
