package models;

public class PermanentEmployee extends Employee implements Evaluable {
    public PermanentEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }

    @Override
    public void evaluatePerformance() {
        System.out.println(name + " has been evaluated with satisfactory performance.");
    }
}
