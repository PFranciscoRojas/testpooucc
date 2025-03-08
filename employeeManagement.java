import java.util.ArrayList;
import java.util.List;

// Clase abstracta Empleado
abstract class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public abstract double calcularBonificacion();

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", Salario: " + salario;
    }
}

// Interfaz Evaluable
interface Evaluable {
    String evaluarDesempeño();
}

// Subclase EmpleadoFijo
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
    public String evaluarDesempeño() {
        return "Desempeño evaluado mediante revisiones anuales.";
    }
}

// Subclase EmpleadoContratado
class EmpleadoContratado extends Empleado implements Evaluable {
    private int mesesContrato;

    public EmpleadoContratado(String nombre, double salario, int mesesContrato) {
        super(nombre, salario);
        this.mesesContrato = mesesContrato;
    }

    @Override
    public double calcularBonificacion() {
        return salario * 0.05;
    }
    @Override
    public String evaluarDesempeño() {
        return "Desempeño evaluado mediante revison de meses contratado.";
    }
}

// Subclase EmpleadoFreelancer que también es evaluable
class EmpleadoFreelancer extends Empleado implements Evaluable {
    private int proyectosCompletados;

    public EmpleadoFreelancer(String nombre, double salario, int proyectosCompletados) {
        super(nombre, salario);
        this.proyectosCompletados = proyectosCompletados;
    }

    @Override
    public double calcularBonificacion() {
        return proyectosCompletados * 100;
    }

    @Override
    public String evaluarDesempeño() {
        return "Desempeño evaluado según proyectos completados y satisfacción del cliente.";
    }
}

// Clase Departamento que contiene una lista de empleados
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
        for (Empleado emp : empleados) {
            System.out.println(emp + " - Bonificación: " + emp.calcularBonificacion());
            if (emp instanceof Evaluable) {
                System.out.println("  " + ((Evaluable) emp).evaluarDesempeño());
            }
        }
    }
}

// Demostración del polimorfismo
class EmployeeManagement {
    public static void main(String[] args) {
        Departamento departamentoTI = new Departamento("Tecnología");
        
        departamentoTI.agregarEmpleado(new EmpleadoFijo("Omar", 3000, 5));
        departamentoTI.agregarEmpleado(new EmpleadoContratado("Valentina", 2500, 12));
        departamentoTI.agregarEmpleado(new EmpleadoFreelancer("Luis", 1500, 10));
        
        departamentoTI.mostrarEmpleados();
    }
}
