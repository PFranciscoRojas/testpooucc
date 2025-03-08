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
        System.out.println("Nombre: " + nombre + ", Salario: " + salario);
    }
}

class EFijo extends Empleado implements Evaluable {
    public EFijo(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.10;
    }

    @Override
    public void evaluarDesempeño() {
        System.out.println(nombre + " tiene un desempeño excelente.");
    }
}

class EContratado extends Empleado {
    public EContratado(String nombre, double salario) {
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

class Departamento {
    private final List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            System.out.println("Bonificación: " + empleado.calcularBonificacion());

            if (empleado instanceof Evaluable evaluable) {
                evaluable.evaluarDesempeño();
            }
        }
        System.out.println("--------------------");
    }
}

public class Empresa {
    public static void main(String[] args) {
        Departamento departamento = new Departamento();

        Empleado empleado1 = new EFijo("Cristian Ruano", 5000);
        Empleado empleado2 = new EContratado("Maria Perez", 4000);

        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);

        departamento.mostrarEmpleados();
    }
}
