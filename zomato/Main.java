import models.*;
import facade.ZomatoCheckoutFacade;
import strategies.UPI;
import factories.NowOrderFactory;

public class Main {
    public static void main(String[] args) {
        // 1. Setup Data
        User user = new User("U001", "John Doe", "123 Tech Lane");
        Restaurant res = new Restaurant("R001", "Pizza Palace", "Downtown");
        MenuItem pizza = new MenuItem("M01", "Margherita", 12.99);
        
        user.getCart().addItem(pizza, res);
        
        // 2. The Facade magic
        ZomatoCheckoutFacade zomato = new ZomatoCheckoutFacade();
        
        // USER STORY: "I want to pay with UPI for my order right now"
        zomato.placeOrder(user, new UPI(), new NowOrderFactory());
    }
}