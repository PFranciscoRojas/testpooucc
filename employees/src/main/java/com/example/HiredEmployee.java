package com.example;

class HiredEmployee extends Employee {
    public HiredEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.8; 
    }
}
