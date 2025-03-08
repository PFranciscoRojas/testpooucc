package com.example;

class PermanentEmployee extends Employee implements IEvaluate {
    public PermanentEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.15; 
    }

    @Override
    public void evaluatePerformance() {
        System.out.println(getName() + " ha sido evaluado con un gran desempeño y deddicacion a su labor.");
    }
}

