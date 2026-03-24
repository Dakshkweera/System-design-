// package models;

// import strategies.IPaymentStrategy;
// import java.util.ArrayList;
// import java.util.List;

// public abstract class Order {
//     // 1. Shared State (Protected so child classes can access them if needed)
//     protected String orderId;
//     protected User user;
//     protected List<MenuItem> items;
//     protected double totalAmount;
    
//     // The Strategy Pattern connection! 
//     // The order knows it needs a payment method, but doesn't care if it's UPI or Card.
//     protected IPaymentStrategy paymentStrategy; 

//     public Order(String orderId, User user, List<MenuItem> items, double totalAmount) {
//         this.orderId = orderId;
//         this.user = user;
//         // Deep copy the cart items so if the cart clears, the order doesn't lose its data!
//         this.items = new ArrayList<>(items); 
//         this.totalAmount = totalAmount;
//     }

//     // 2. The Abstract Contract
//     // Every child class MUST implement this method, or the code won't compile.
//     public abstract String getOrderType();

//     // 3. Setters for behavior injection
//     public void setPaymentStrategy(IPaymentStrategy strategy) {
//         this.paymentStrategy = strategy;
//     }
    
//     // Getters
//     public String getOrderId() { return orderId; }
//     public double getTotalAmount() { return totalAmount; }
// }