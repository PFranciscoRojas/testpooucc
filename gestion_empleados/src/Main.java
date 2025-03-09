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

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", Salario: " + salario + ", Bonificación: " + calcularBonificacion();
    }
}


interface Evaluable {
    void evaluarDesempeño();
}


class EmpleadoFijo extends Empleado implements Evaluable {
    private int añosExperiencia;

    public EmpleadoFijo(String nombre, double salario, int añosExperiencia) {
        super(nombre, salario);
        this.añosExperiencia = añosExperiencia;
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.10 + (añosExperiencia * 50);
    }

    @Override
    public void evaluarDesempeño() {
        System.out.println(nombre + " ha sido evaluado como empleado fijo con " + añosExperiencia + " años de experiencia.");
    }
}


class EmpleadoContratado extends Empleado {
    private int mesesContrato;

    public EmpleadoContratado(String nombre, double salario, int mesesContrato) {
        super(nombre, salario);
        this.mesesContrato = mesesContrato;
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.05 + (mesesContrato * 10);
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
        System.out.println("Departamento: " + nombre);
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    public void evaluarEmpleados() {
        for (Empleado e : empleados) {
            if (e instanceof Evaluable) {
                ((Evaluable) e).evaluarDesempeño();
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Departamento departamentoTI = new Departamento("TI");

        Empleado empleado1 = new EmpleadoFijo("Carlos", 3000000, 5);
        Empleado empleado2 = new EmpleadoContratado("Ana", 2500000, 12);
        Empleado empleado3 = new EmpleadoFijo("Luis", 3200000, 3);

        departamentoTI.agregarEmpleado(empleado1);
        departamentoTI.agregarEmpleado(empleado2);
        departamentoTI.agregarEmpleado(empleado3);

        departamentoTI.mostrarEmpleados();
        departamentoTI.evaluarEmpleados(); 
    }
}
