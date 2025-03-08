import java.util.ArrayList;
import java.util.List;

public class Departamento {
    public String nombreDepartamento;
    public List<Empleado> listaEmpleados;

    public Departamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
        this.listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public void listarEmpleados() {
        for (Empleado empleado : listaEmpleados) {
            System.out.println("El empleado " + empleado.nombre + " pertenece al departamento de " + nombreDepartamento + " y tiene una bonificacion de: " + empleado.calcularBonificacion());
        }
    }
}
