package SRP_follow;

class Employee {

    String name;
    Integer salary;

    public Employee(String name, Integer salary) {

        this.name = name;
        this.salary = salary;
    }
}

class BonusCalculator {

    public Integer calculateBonus(Employee e) {

        if(e.salary > 50000) {

            return (20 * e.salary) / 100;
        }
        else {

            return (10 * e.salary) / 100;
        }
    }
}

class EmployeeRepository {

    public void save(Employee e) {

        System.out.println("Employee data is saving...");
    }
}

class ReportPrinter {

    public void print(Employee e, Integer bonus) {

        System.out.println("Name: " + e.name);

        System.out.println("Salary: " + e.salary);

        System.out.println("Bonus: " + bonus);
    }
}

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee("Daksh", 100000);

        BonusCalculator bc = new BonusCalculator();

        Integer bonus = bc.calculateBonus(e1);

        ReportPrinter rp = new ReportPrinter();

        rp.print(e1, bonus);

        EmployeeRepository er = new EmployeeRepository();

        er.save(e1);
    }
}