package com.example;

class EvaluatedContractEmployee extends ContractEmployee implements IEvaluable {
    public EvaluatedContractEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void evaluatePerformance() {
        System.out.println(name + " has been evaluated based on project completion.");
    }
}
