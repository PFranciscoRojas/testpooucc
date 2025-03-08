package org.example;

public class EmpleadoFijo extends Empleado implements Evaluable {
  public EmpleadoFijo(String nombre, double salario) {
    super(nombre, salario);
  }

  @Override
  public double calcularBonificacion() {
    return salario * 0.10;
  }

  @Override
  public void evaluarDesempeño() {
    System.out.println(nombre + " ha sido evaluado con desempeño excelente.");
  }
}
