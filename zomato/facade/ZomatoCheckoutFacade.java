package facade;

import models.*;
import strategies.IPaymentStrategy;
import factories.IOrderFactory;
import managers.OrderManager;

public class ZomatoCheckoutFacade {
    public void placeOrder(User user, IPaymentStrategy payment, IOrderFactory factory) {
        System.out.println("--- Starting Checkout for " + user.getName() + " ---");
        
        // 1. Create Order via Factory
        Order order = factory.createOrder(user);
        
        // 2. Attach Payment Strategy
        order.setPaymentStrategy(payment);
        
        // 3. Process Payment
        order.processPayment();
        
        // 4. Save to Manager
        OrderManager.getInstance().addOrder(order);
        
        // 5. Success!
        System.out.println("Order status: " + order.getOrderType());
        user.getCart().clear();
        System.out.println("Cart cleared. Thank you!");
    }
}