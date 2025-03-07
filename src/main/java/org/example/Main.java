package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public abstract double calcularBonificacion();
}

class EmpleadoFijo extends Empleado {
    public EmpleadoFijo(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.10;
    }
}

class EmpleadoContratado extends Empleado {
    public EmpleadoContratado(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.05;
    }
}

interface Evaluable {
    void evaluarDesempeño();
}

class EmpleadoFijoEvaluable extends EmpleadoFijo implements Evaluable {
    public EmpleadoFijoEvaluable(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public void evaluarDesempeño() {
        System.out.println("Evaluando desempeño de " + nombre);
    }
}

class EmpleadoContratadoEvaluable extends EmpleadoContratado implements Evaluable {
    public EmpleadoContratadoEvaluable(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public void evaluarDesempeño() {
        System.out.println("Evaluando desempeño de contratado: " + nombre);
    }
}

class Departamento {
    private final List<Empleado> empleados;

    public Departamento() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }


    //polimorfismo
    public void mostrarBonificaciones() {
        for (Empleado empleado : empleados) {
            System.out.println("Empleado: " + empleado.getNombre() +
                    ", Bonificación: " + empleado.calcularBonificacion());
        }
    }

    public void evaluarDesempeño() {
        for (Empleado empleado : empleados)
            if (empleado instanceof Evaluable evaluable) {
                evaluable.evaluarDesempeño();
            }
        }
    }


public class Main {
    public static void main(String[] args) {
        Departamento departamento = new Departamento();

        Empleado emp1 = new EmpleadoFijo("Juan", 3000);
        Empleado emp2 = new EmpleadoContratado("Ana", 2000);
        Empleado emp3 = new EmpleadoFijoEvaluable("Carlos", 4000);
        Empleado emp4 = new EmpleadoContratadoEvaluable("Laura", 2500);

        departamento.agregarEmpleado(emp1);
        departamento.agregarEmpleado(emp2);
        departamento.agregarEmpleado(emp3);
        departamento.agregarEmpleado(emp4);

        System.out.println("=== Bonificaciones de Empleados ===");
        departamento.mostrarBonificaciones();

        System.out.println("\n=== Evaluación de Desempeño ===");
        departamento.evaluarDesempeño();
    }
}