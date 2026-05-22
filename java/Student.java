public class Student {
    Integer roll;
    String name;
    String gender;

    Student(Integer roll,String name,String gender){
        this.roll = roll;
        this.name = name;
        this.gender = gender;
    }

    public void intro(){
        System.out.println("Hello my name is "+name+". My roll no is "+roll+". my gender is "+gender);
    }

    public static void main(String[] banana){
        Student s1 = new Student(01,"Daksh","male");
        Student s2 = new Student(02,"harry","male");
        Student s3 = new Student(03,"geeta","female");

        s1.intro();
        s2.intro();
        s3.intro();
    }
}
