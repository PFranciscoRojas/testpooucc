package com.taller;

public class EmpleadoFijo extends Empleado implements Evaluable {
    private int antiguedad;
    private int horasExtras;
    private int diasTarde;
    private int diasAusente;

    public EmpleadoFijo(String nombre, int salario, int antiguedad){
        super(nombre, salario);
        this.antiguedad = antiguedad;
    }

    public void setAsistencia(int horasExtras, int diasTarde, int diasAusente) {
        this.horasExtras = horasExtras;
        this.diasTarde = diasTarde;
        this.diasAusente = diasAusente;
    }

    @Override
    public void calcularBonificacion(){
        int bonificacion = 0;
        if (antiguedad > 10){
            bonificacion = 1000;
        } else if (antiguedad > 5){
            bonificacion = 500;
        } else {
            bonificacion = 100;
        }
        for (int i = 0; i < horasExtras; i++){
            bonificacion += 50;
        }
        salario += bonificacion;
    }

    @Override
    public void evaluarDesempeno(){
        int puntuacion = 100;

        puntuacion -= diasTarde * 2;
        puntuacion -= diasAusente * 5;
        puntuacion += horasExtras * 3;

        if(puntuacion > 90){
            System.out.println(this.nombre + " Excelente desempeño");
        }else if (puntuacion > 70){
            System.out.println(this.nombre + " Buen desempeño");
        }else {
            System.out.println(this.nombre + " Desempeño deficiente");
        }
        
    }
    
}
