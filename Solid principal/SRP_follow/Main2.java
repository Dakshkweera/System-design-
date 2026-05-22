package SRP_follow;

// Employee entity class
class Employee {

    String name;
    int salary;

    // Constructor
    public Employee(String name, int salary) {

        this.name = name;
        this.salary = salary;
    }
}


// Handles bonus calculation responsibility
class BonusCalculator {

    public int calculateBonus(Employee e) {

        if (e.salary > 50000) {

            return (20 * e.salary) / 100;
        }

        return (10 * e.salary) / 100;
    }
}


// Handles database responsibility
class EmployeeRepository {

    public void save(Employee e) {

        System.out.println("Saving employee data to database...");
    }
}


// Handles report printing responsibility
class ReportPrinter {

    public void print(Employee e, int bonus) {

        System.out.println("----- Employee Report -----");

        System.out.println("Name: " + e.name);

        System.out.println("Salary: " + e.salary);

        System.out.println("Bonus: " + bonus);
    }
}


// Orchestrator / Service Layer
class EmployeeService {

    BonusCalculator bonusCalculator;

    EmployeeRepository repository;

    ReportPrinter printer;

    // Constructor
    public EmployeeService() {

        bonusCalculator = new BonusCalculator();

        repository = new EmployeeRepository();

        printer = new ReportPrinter();
    }


    // Main workflow method
    public void processEmployee(Employee e) {

        int bonus = bonusCalculator.calculateBonus(e);

        printer.print(e, bonus);

        repository.save(e);
    }
}


// Entry point
public class Main2 {

    public static void main(String[] args) {

        Employee e1 = new Employee("Daksh", 100000);

        EmployeeService service = new EmployeeService();

        service.processEmployee(e1);
    }
}
