public class Mobile{
    String brand;
    Integer price;
    
    Mobile(String brand, Integer price){
        this.brand = brand;
        this.price = price;
    }

    public void display(){
        System.out.println("Brand name :"+brand);
        System.out.println("Price is :"+price);
    }

    public static void main(String[] args){
        Mobile a = new Mobile("MOTOROLA",20000);
        a.display();
    }
}