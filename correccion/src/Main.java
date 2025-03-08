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
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: " + salario);
        System.out.println("Bonificación: " + calcularBonificacion());
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
        System.out.println(nombre + " desempeño increible");
    }
}


class EmpleadoContratado extends Empleado {
    private int duracionContrato; 

    public EmpleadoContratado(String nombre, double salario, int duracionContrato) {
        super(nombre, salario);
        this.duracionContrato = duracionContrato;
    }

    @Override
    public double calcularBonificacion() {
        
        return duracionContrato > 6 ? 500 : 0;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Duración del contrato: " + duracionContrato + " meses");
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

    public void mostrarInformacionEmpleados() {
        System.out.println("Departamento: " + nombre);
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            if (empleado instanceof Evaluable) {
                ((Evaluable) empleado).evaluarDesempeño();
            }
            
        }
    }
}


public class Main {
    public static void main(String[] args) {
        
        EmpleadoFijo empleado1 = new EmpleadoFijo("mario castañeda", 3000);
        EmpleadoContratado empleado2 = new EmpleadoContratado("mariana castillo", 2500, 12);
        EmpleadoFijo empleado3 = new EmpleadoFijo("giovanny ramos", 4000);

        
        Departamento departamento = new Departamento("Ventas");
        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);
        departamento.agregarEmpleado(empleado3);

        
        departamento.mostrarInformacionEmpleados();
    }
}