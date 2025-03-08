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

class EmpleadoFijo extends Empleado implements Evaluable {
    public EmpleadoFijo(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.10;
    }

    @Override
    public String evaluarDesempeño() {
        return "Desempeño evaluado con métricas internas.";
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
    String evaluarDesempeño();
}

class EmpleadoPorHoras extends Empleado implements Evaluable {
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, double salario, int horasTrabajadas) {
        super(nombre, salario);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularBonificacion() {
        return horasTrabajadas > 40 ? salario * 0.07 : salario * 0.03;
    }

    @Override
    public String evaluarDesempeño() {
        return "Evaluación basada en horas trabajadas.";
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
            System.out.println("Empleado: " + e.getNombre() +
                    ", Salario: " + e.getSalario() +
                    ", Bonificación: " + e.calcularBonificacion());

            if (e instanceof Evaluable) {
                System.out.println("Evaluación: " + ((Evaluable) e).evaluarDesempeño());
            }
            System.out.println("----------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Departamento departamento = new Departamento();

        Empleado fijo = new EmpleadoFijo("Nicolas", 5000);
        Empleado contratado = new EmpleadoContratado("Luis miguel", 4000);
        Empleado porHoras = new EmpleadoPorHoras("Miguel polo", 3000, 45);

        departamento.agregarEmpleado(fijo);
        departamento.agregarEmpleado(contratado);
        departamento.agregarEmpleado(porHoras);

        departamento.mostrarEmpleados();
    }
}
