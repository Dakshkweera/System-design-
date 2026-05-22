package DIP_follow;

interface Keyboard{
    void type();
}

class Wiredkeyboard implements Keyboard{
    public void type(){
        System.out.println("Started typing using Wiredkeyboard");
    }
}

class Gamekeyboard implements Keyboard{
    public void type(){
        System.out.println("Started typing using Gamekeyboard");
    }
}