package models;

import strategies.IPaymentStrategy;
import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    protected String orderId;
    protected User user;
    protected List<MenuItem> items;
    protected double totalAmount;
    protected IPaymentStrategy paymentStrategy; 

    public Order(String orderId, User user, List<MenuItem> items, double totalAmount) {
        this.orderId = orderId;
        this.user = user;
        this.items = new ArrayList<>(items); 
        this.totalAmount = totalAmount;
    }

    public abstract String getOrderType();

    public void setPaymentStrategy(IPaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    
    public void processPayment() {
        if (paymentStrategy != null) {
            paymentStrategy.pay(totalAmount);
        } else {
            System.out.println("Error: No payment method selected!");
        }
    }

    // Getters
    public String getOrderId() { return orderId; }
    public double getTotalAmount() { return totalAmount; }
}