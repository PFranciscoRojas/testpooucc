import java.util.ArrayList;
import java.util.List;

// Clase abstracta Empleado con atributos comunes y método abstracto calcularBonificacion()
abstract class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public abstract double calcularBonificacion();

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: " + salario);
        System.out.println("Bonificación: " + calcularBonificacion());
    }
}

// Subclases que extienden Empleado y definen su cálculo de bonificación
class EmpleadoFijo extends Empleado implements Evaluable {
    public EmpleadoFijo(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.15;
    }

    @Override
    public void evaluarDesempeño() {
        System.out.println(nombre + " tiene un desempeño excelente como empleado fijo.");
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

// Definición de la interfaz Evaluable con un método evaluarDesempeño()
interface Evaluable {
    void evaluarDesempeño();
}

// Clase Departamento que usa composición para contener una lista de empleados
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
        System.out.println("Departamento: " + nombre);
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Lista de empleados para demostrar polimorfismo
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoFijo("Carlos Gómez", 6000));
        empleados.add(new EmpleadoContratado("Ana López", 4000));
        empleados.add(new EmpleadoFijo("Luis Pérez", 7000));

        // Invocamos los métodos sin conocer el tipo exacto del empleado
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            System.out.println();
        }

        
    }
}
