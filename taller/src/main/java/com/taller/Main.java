package com.taller;

public class Main {
    public static void main(String[] args) {
        Departamento departamento = new Departamento("Recursos Humanos");

        EmpleadoFijo empleado1 = new EmpleadoFijo("Juan", 1000, 5);
        empleado1.setAsistencia(5, 0, 0);
        empleado1.calcularBonificacion();//Utilizamos la función de empleado con la implementación de EmpleadoFijo a través de polimorfismo
        empleado1.evaluarDesempeno();

        EmpleadoContratado empleado2 = new EmpleadoContratado("Maria", 800, 6);
        empleado2.setTareas(10, 12);
        empleado2.calcularBonificacion();//Utilizamos la función de empleado con la implementación de EmpleadoContratado a través de polimorfismo
        empleado2.evaluarDesempeno();
        System.out.println("Salario de " + empleado1.getNombre() + " = " +empleado1.getSalario());//Accedemos a las funciones de Empleado
        System.out.println("Salario de " + empleado2.getNombre() + " = " +empleado2.getSalario());

        departamento.agregarEmpleado(empleado1);//La función permite agregar a ambos empleados tanto fijo como contratado a pesar de ser clases distintas, pues provienen de la misma clase padre
        departamento.agregarEmpleado(empleado2);

        departamento.mostrarEmpleados();
    }
}