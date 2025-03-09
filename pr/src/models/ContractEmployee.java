package models;

public class ContractEmployee extends Employee {
    private int contractMonths;

    public ContractEmployee(String name, double salary, int contractMonths) {
        super(name, salary);
        this.contractMonths = contractMonths;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05;
    }

    public int getContractMonths() {
        return contractMonths;
    }
}
