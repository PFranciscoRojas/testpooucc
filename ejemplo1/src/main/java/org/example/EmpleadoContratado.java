package org.example;

public class EmpleadoContratado extends Empleado implements Evaluable {
  public EmpleadoContratado(String nombre, double salario) {
    super(nombre, salario);
  }

  @Override
  public double calcularBonificacion() {
    return salario * 0.05;
  }
  @Override
  public void evaluarDesempeño() {
    System.out.println(nombre + " ha sido evaluado con desempeño excelente.");
  }
}
