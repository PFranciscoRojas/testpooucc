import models.*;
import management.Department;

public class main {
    public static void main(String[] args) {
        Department itDepartment = new Department("IT");

        Employee e1 = new PermanentEmployee("Carlos", 5000);
        Employee e2 = new ContractEmployee("Ana", 4000, 12);
        Employee e3 = new TemporaryEmployee("Luis", 3000, 120);

        itDepartment.addEmployee(e1);
        itDepartment.addEmployee(e2);
        itDepartment.addEmployee(e3);

        itDepartment.displayEmployees();
    }
}
