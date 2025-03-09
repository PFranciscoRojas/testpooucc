package management;

import models.Employee;
import models.Evaluable;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayEmployees() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            emp.displayInfo();
            if (emp instanceof Evaluable) {
                ((Evaluable) emp).evaluatePerformance();
            }
            System.out.println("------------------");
        }
    }
}
