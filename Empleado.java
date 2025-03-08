public abstract class Empleado {
    public String nombre;
    public double salario;

    public Empleado (String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public abstract double calcularBonificacion();
}
