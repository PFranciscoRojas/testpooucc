public class EmpleadoContratado extends Empleado implements Evaluable{
    String tipoContrato;
    int escalaValoracion;

    public EmpleadoContratado(String nombre, double salario, String tipoContrato, int  escalaValoracion) {
        super(nombre, salario);
        this.tipoContrato = tipoContrato;
        this.escalaValoracion = escalaValoracion;
    }

    @Override
    public double calcularBonificacion() {
        if (tipoContrato.equals("Contrato temporal")) {
            return salario * 0.2;
        } else if (tipoContrato.equals("Contrato de aprendizaje")) {
            return salario * 0.3;
        };
        return 0;
    }

    @Override
    public void evaluarDesempeno() {
        switch (escalaValoracion) {
            case 5:
                System.out.println("El empleado " + nombre + " tuvo un desempeño excelente");
                break;
            case 4:
                System.out.println("El empleado " + nombre + " tuvo un desempeño bueno");
                break;
            case 3:
                System.out.println("El empleado " + nombre + " tuvo un desempeño regular");
                break;
            case 2:
                System.out.println("El empleado " + nombre + " tuvo un desempeño bajo");
                break;
            case 1:
                System.out.println("El empleado " + nombre + " tuvo un desempeño muy bajo");
                break;
            default:
                System.out.println("Fuera del rango de desempeño");
        }
    }

}
