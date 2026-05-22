package DIP_follow;

public class Computer {
    Keyboard keyboard;
    public Computer(Keyboard key){
        this.keyboard = key;
    }

    public void start(){
        keyboard.type();
    }
}
