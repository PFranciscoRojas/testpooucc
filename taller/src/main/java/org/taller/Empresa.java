package org.taller;
import java.util.*;

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

interface Evaluable {
    void evaluarDesempeño();
}

class EmpleadoFijo extends Empleado implements Evaluable {
    public EmpleadoFijo(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.10;
    }

    @Override
    public void evaluarDesempeño() {
        System.out.println(nombre + " ha sido evaluado con un desempeño EXCELENTE.");
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

class EmpleadoTemporal extends Empleado implements Evaluable {
    public EmpleadoTemporal(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.03;
    }

    @Override
    public void evaluarDesempeño() {
        System.out.println(nombre + " ha sido evaluado con un desempeño SATISFACTORIO.");
    }
}

class Departamento {
    private List<Empleado> empleados;

    public Departamento() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        for (Empleado e : empleados) {
            System.out.println("Empleado: " + e.getNombre() + ", Salario: " + e.getSalario() + ", Bonificación: " + e.calcularBonificacion());
            if (e instanceof Evaluable) {
                ((Evaluable) e).evaluarDesempeño();
            }
        }
    }
}

// Clase principal para probar el código
public class Empresa {
    public static void main(String[] args) {
        Departamento departamento = new Departamento();
        
        Empleado fijo = new EmpleadoFijo("Carlos", 3000);
        Empleado contratado = new EmpleadoContratado("Ana", 2500);
        Empleado temporal = new EmpleadoTemporal("Luis", 2000);
        
        departamento.agregarEmpleado(fijo);
        departamento.agregarEmpleado(contratado);
        departamento.agregarEmpleado(temporal);
        
        departamento.mostrarEmpleados();
    }
}
