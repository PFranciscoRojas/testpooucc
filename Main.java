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
}

interface Evaluable {
    String evaluarDesempeno();
}

class EmpleadoFijo extends Empleado implements Evaluable {
    private int anosExperiencia;

    public EmpleadoFijo(String nombre, double salario, int anosExperiencia) {
        super(nombre, salario);
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public double calcularBonificacion() {
        return this.salario * 0.10;
    }

    @Override
    public String evaluarDesempeno() {
        return (anosExperiencia > 5) ? "Alto" : "Medio";
    }
}

class EmpleadoContratado extends Empleado {
    private int horasTrabajadas;

    public EmpleadoContratado(String nombre, double salario, int horasTrabajadas) {
        super(nombre, salario);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularBonificacion() {
        return horasTrabajadas * 20;
    }
}

class Departamento {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.nombre + ": Bonificación " + empleado.calcularBonificacion());
            if (empleado instanceof Evaluable) {
                System.out.println("Desempeño: " + ((Evaluable) empleado).evaluarDesempeno());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Departamento departamento = new Departamento();
        departamento.agregarEmpleado(new EmpleadoFijo("Carlos", 5000, 6));
        departamento.agregarEmpleado(new EmpleadoContratado("Ana", 3000, 50));
        
        departamento.mostrarEmpleados();
    }
}

