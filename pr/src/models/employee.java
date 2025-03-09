package models;

public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Salary: " + salary + ", Bonus: " + calculateBonus());
    }
}
