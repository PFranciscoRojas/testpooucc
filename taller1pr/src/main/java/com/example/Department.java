package com.example;

import java.util.ArrayList;
import java.util.List;

class Department {
    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void showEmployees() {
        for (Employee e : employees) {
            e.displayInfo();
            if (e instanceof IEvaluable) {
                ((IEvaluable) e).evaluatePerformance();
            }
            System.out.println("----------------------");
        }
    }
}