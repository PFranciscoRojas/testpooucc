package com.example;

import java.util.ArrayList;
import java.util.List;


abstract class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public abstract double calcularBonificacion();

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }
}


class EmpleadoFijo extends Empleado {
    public EmpleadoFijo(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.10; // Bonificación del 10%
    }
}

class EmpleadoContratado extends Empleado {
    public EmpleadoContratado(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.05; // Bonificación del 5%
    }
}


interface Evaluable {
    double evaluarDesempeno();
}


class EmpleadoEvaluado extends EmpleadoFijo implements Evaluable {
    public EmpleadoEvaluado(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double evaluarDesempeno() {
        return Math.random() * 10; 
    }
}


class Departamento {
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        for (Empleado e : empleados) {
            System.out.println("Empleado: " + e.getNombre() + " - Salario: " + e.getSalario() +
                    " - Bonificación: " + e.calcularBonificacion());
        }
    }
}


class SistemaGestionEmpleados {
    public static void main(String[] args) {
        Departamento departamento = new Departamento("Recursos Humanos");

        Empleado emp1 = new EmpleadoFijo("santiago", 3000000);
        Empleado emp2 = new EmpleadoContratado("Maria", 2500000);
        EmpleadoEvaluado emp3 = new EmpleadoEvaluado("samuel", 3500000);

        departamento.agregarEmpleado(emp1);
        departamento.agregarEmpleado(emp2);
        departamento.agregarEmpleado(emp3);

        departamento.mostrarEmpleados();

        System.out.println("Evaluación de desempeño de " + emp3.getNombre() + ": " + emp3.evaluarDesempeno());
    }
}
