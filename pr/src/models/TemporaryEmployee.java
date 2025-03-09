package models;

public class TemporaryEmployee extends Employee implements Evaluable {
    private int hoursWorked;

    public TemporaryEmployee(String name, double salary, int hoursWorked) {
        super(name, salary);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateBonus() {
        return hoursWorked > 100 ? salary * 0.07 : salary * 0.03;
    }

    @Override
    public void evaluatePerformance() {
        System.out.println(name + " has been evaluated with exceptional performance.");
    }
}
