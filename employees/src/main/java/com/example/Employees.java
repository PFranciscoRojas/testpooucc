package com.example;

public class Employees {
    public static void main(String[] args) {
        Departament departament = new Departament();

        Employee employee1 = new PermanentEmployee("Jose Quiñones del Totumo", 10000);
        Employee employee2 = new HiredEmployee("Almenares Jose de Snatander", 7000);
        Employee employee3 = new PermanentEmployee("Carlos Sainz Vazquez de Castro Cenamor Rincon Rebollo Virto Moreno de Aranda Don Per Urrielagoria Perez del Pulgar", 15000);
        Employee employee4 = new HiredEmployee("Lucius Vellachrono", 5500);

        departament.addEmployee(employee1);
        departament.addEmployee(employee2);
        departament.addEmployee(employee3);
        departament.addEmployee(employee4);

        System.out.println("Salarios de empleados:");
        departament.showSalary();

        System.out.println("\nBonificaciones de empleados:");
        departament.showBonus();

        System.out.println("\nEvaluacion de desempeño:");
        departament.evaluateEmployee();
    }
}