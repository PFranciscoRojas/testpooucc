public class EmpleadoFijo extends Empleado{
    public int diasTrabajados;

    public EmpleadoFijo(String nombre, double salario, int diasTrabajados) {
        super(nombre, salario);
        this.diasTrabajados = diasTrabajados;
    }

    @Override
    public double calcularBonificacion() {
        return (salario * diasTrabajados) / 360;
    }
}
