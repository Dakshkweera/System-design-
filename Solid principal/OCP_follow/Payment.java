package OCP_follow;

interface Payment {
    void pay();
}

class UPI implements Payment{
    public void pay(){
        System.out.println("payment through UPI");
    }
}

class Creditcard implements Payment{
    public void pay(){
        System.out.println("payment through Creditcard");
    }
}

class Blockchain implements Payment{
    public void pay(){
        System.out.println("payment through Blockchain");
    }
}

