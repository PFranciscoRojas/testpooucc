package com.example;

public class Main {
    public static void main(String[] args) {
        Department department = new Department();
        
        Employee emp1 = new PermanentEmployee("Alice", 5000);
        Employee emp2 = new ContractEmployee("Bob", 4000);
        Employee emp3 = new EvaluatedContractEmployee("Charlie", 4500);
        
        department.addEmployee(emp1);
        department.addEmployee(emp2);
        department.addEmployee(emp3);
        
        department.showEmployees();
    }
}