package com.taller;

public class EmpleadoContratado extends Empleado implements Evaluable {
    private int mesesContrato;
    private int tareasCompletadas;
    private int tareasAsignadas;

    public EmpleadoContratado(String nombre, int salario, int mesesContrato){
        super(nombre, salario);
        this.mesesContrato = mesesContrato;
    }

    public void setTareas(int completadas, int asignadas) {
        this.tareasCompletadas = completadas;
        this.tareasAsignadas = asignadas;
    }

    @Override
    public void calcularBonificacion(){
        int bonificacion = 0;
        if (mesesContrato > 12){
            bonificacion = 1000;
        } else if (mesesContrato > 6){
            bonificacion = 500;
        } else {
            bonificacion = 100;
        }
        salario += bonificacion;
    }

    @Override
    public void evaluarDesempeno(){
        double efectividad = tareasCompletadas/tareasAsignadas * 100;

        if(efectividad > 90){
            System.out.println(this.nombre + " Excelente desempeño");
        }else if (efectividad > 70){
            System.out.println(this.nombre + " Buen desempeño");
        }else {
            System.out.println(this.nombre + " Desempeño deficiente");
        }
    }
    
}
