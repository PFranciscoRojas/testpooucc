package com.example;

class PermanentEmployee extends Employee implements IEvaluable {
    public PermanentEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.1; // Fixed bonus of 10%
    }

    @Override
    public void evaluatePerformance() {
        System.out.println(name + " has a fixed evaluation system.");
    }
}