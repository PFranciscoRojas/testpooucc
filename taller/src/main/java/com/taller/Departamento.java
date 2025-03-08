package com.taller;

import java.util.ArrayList;

public class Departamento {
    private ArrayList<Empleado> empleados;
    private String nombre;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<Empleado>();
    }

    public void agregarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    public void eliminarEmpleado(String nombre){
        for (Empleado empleado : empleados){
            if (empleado.getNombre().equals(nombre)){
                empleados.remove(empleado);
                break;
            }
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void mostrarEmpleados(){
        for (Empleado empleado : empleados){
            System.out.println(empleado.getNombre());
        }
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
