package DIP_follow;

public class Main {
    public static void main(String[] arg){
        Computer com = new Computer(new Gamekeyboard());
        com.start();
    }
}
