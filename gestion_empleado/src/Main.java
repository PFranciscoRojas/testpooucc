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

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + ", Salario: $" + salario + ", Bonificación: $" + calcularBonificacion());
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
        return salario * 0.1;
    }

    @Override
    public void evaluarDesempeño() {
        System.out.println(nombre + " ha sido evaluado con un desempeño excelente.");
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
            e.mostrarInformacion();
            if (e instanceof Evaluable) {
                ((Evaluable) e).evaluarDesempeño();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Empleado fijo1 = new EmpleadoFijo("Daniela Martinez", 3000000);
        Empleado fijo2 = new EmpleadoFijo("Juan Vallejo", 3500000);
        Empleado contratado1 = new EmpleadoContratado("Camilo Viveros", 2000000);

        Departamento departamentoTI = new Departamento("Tecnologia");
        departamentoTI.agregarEmpleado(fijo1);
        departamentoTI.agregarEmpleado(fijo2);
        departamentoTI.agregarEmpleado(contratado1);

        departamentoTI.mostrarEmpleados();
    }
}
