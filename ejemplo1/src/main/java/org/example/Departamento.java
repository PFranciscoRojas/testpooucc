package org.example;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
  private List<Empleado> empleados = new ArrayList<>();

  public void agregarEmpleado(Empleado empleado) {
    empleados.add(empleado);
  }

  public void mostrarEmpleados() {
    for (Empleado empleado : empleados) {
      System.out.println("Empleado: " + empleado.getNombre() + ", Salario: " + empleado.getSalario() +
        ", Bonificación: " + empleado.calcularBonificacion());
    }
  }
}
