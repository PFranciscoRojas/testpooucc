package com.example;

import java.util.ArrayList;
import java.util.List;

class Departament {
    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void showBonus() {
        employees.forEach(emp -> 
        System.out.println(emp.getName() + " | Su bonificacion es de: " + emp.calculateBonus()));
    }

    public void evaluateEmployee() {
        employees.forEach(emp -> {
            if (emp instanceof IEvaluate evaluate) {
                evaluate.evaluatePerformance();
            }
        });
    }

    public void showSalary() {
        employees.forEach(emp ->
            System.out.println(emp.getName() + " | Su salario es de: " + emp.getSalary()));
    }
}
