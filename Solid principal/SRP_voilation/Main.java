class Employee{
    String name;
    Integer salary;
    Integer bonus;

    public Employee(String name, Integer salary){
        this.name = name;
        this.salary = salary;
    }

    public Integer Calbonus(){
        if(salary>50000){
            bonus = ( 20*salary)/100;
        }
        else bonus= 10*salary/100;

        return bonus;
    }

    public void savetodb(){
        System.out.println("saved in mongodb");
    }

    public void Report(){
        System.out.println("Name: "+ name);
        System.out.println("Salary "+ salary);
        bonus = Calbonus();
        System.out.println("bonus" + bonus);
    }
}


public class Main{
    public static void main(String[] args){
        Employee e1 = new Employee("Daksh", 1000000);
        e1.Report();
    }
}