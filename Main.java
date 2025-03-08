public class Main {
    public static void main(String[] args) {
        Departamento departamento1 = new Departamento("Ingenieria");
        Departamento departamento2 = new Departamento("Marketing");

        EmpleadoFijo empleado1 = new EmpleadoFijo("Mario", 5000, 90);
        EmpleadoFijo empleado2 = new EmpleadoFijo("Fernando", 7000, 60);
        EmpleadoContratado empleado3 = new EmpleadoContratado("Juan", 10000, "Contrato de aprendizaje", 4);
        EmpleadoContratado empleado4 = new EmpleadoContratado("Felipe", 9000, "Contrato temporal", 2);

        // Agregando empleados 1 y 3 al departamento 1
        departamento1.agregarEmpleado(empleado1);
        departamento1.agregarEmpleado(empleado3);

        // Agregando empleados 2 y 4 al departamento 2
        departamento2.agregarEmpleado(empleado2);
        departamento2.agregarEmpleado(empleado4);

        // Listar empleados con sus calculos
        departamento1.listarEmpleados();
        departamento2.listarEmpleados();

        // Empleados 3 y 4 son contratados y se les evalua el desempeño
        empleado3.evaluarDesempeno();
        empleado4.evaluarDesempeno();
    }
}
