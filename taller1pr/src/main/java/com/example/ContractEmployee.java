package com.example;

class ContractEmployee extends Employee {
    public ContractEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05; // Contract employees get 5% bonus
    }
}
