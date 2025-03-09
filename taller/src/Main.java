import java.util.ArrayList;

interface Evaluable { void evaluarDesempeno(); }

abstract class Empleado {
    protected String nombre;
    protected int salario;
    public Empleado(String nombre, int salario) { this.nombre = nombre; this.salario = salario; }
    public abstract void calcularBonificacion();
    public String getNombre() { return nombre; }
    public int getSalario() { return salario; }
}

class EmpleadoContratado extends Empleado implements Evaluable {
    private int contrato, tareas, totalTareas;
    public EmpleadoContratado(String nombre, int salario, int contrato) { super(nombre, salario); this.contrato = contrato; }
    public void asignarTareas(int tareas, int total) { this.tareas = tareas; this.totalTareas = total; }
    @Override public void calcularBonificacion() { salario += (contrato > 12) ? 1200 : (contrato > 6) ? 600 : 200; }
    @Override public void evaluarDesempeno() { System.out.println(nombre + ((tareas * 100 / totalTareas) > 85 ? " excelente" : " necesita mejorar")); }
}

class EmpleadoFijo extends Empleado implements Evaluable {
    private int antiguedad, extras, tardanzas, ausencias;
    public EmpleadoFijo(String nombre, int salario, int antiguedad) { super(nombre, salario); this.antiguedad = antiguedad; }
    public void registrarAsistencia(int extras, int tardanzas, int ausencias) { this.extras = extras; this.tardanzas = tardanzas; this.ausencias = ausencias; }
    @Override public void calcularBonificacion() { salario += (antiguedad > 10 ? 1200 : (antiguedad > 5 ? 600 : 200)) + (extras * 60); }
    @Override public void evaluarDesempeno() { System.out.println(nombre + ((100 - tardanzas * 3 - ausencias * 6 + extras * 2) > 85 ? " sobresaliente" : " necesita mejorar")); }
}

class Departamento {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private String nombre;
    public Departamento(String nombre) { this.nombre = nombre; }
    public void agregarEmpleado(Empleado e) { empleados.add(e); }
    public String getNombre() { return nombre; } 
    public void mostrarEmpleados() { empleados.forEach(e -> System.out.println("- " + e.getNombre() + ", Salario: " + e.getSalario())); }
}

public class Main {
    public static void main(String[] args) {
        Departamento rrhh = new Departamento("Talento Humano");
        EmpleadoFijo emp1 = new EmpleadoFijo("Messi", 1100, 6);
        emp1.registrarAsistencia(8, 1, 0); emp1.calcularBonificacion(); emp1.evaluarDesempeno();
        EmpleadoContratado emp2 = new EmpleadoContratado("Cristiano", 900, 8);
        emp2.asignarTareas(15, 18); emp2.calcularBonificacion(); emp2.evaluarDesempeno();
        rrhh.agregarEmpleado(emp1); rrhh.agregarEmpleado(emp2);
        System.out.println("Empleados en " + rrhh.getNombre() + ":");
        rrhh.mostrarEmpleados();
    }
}
