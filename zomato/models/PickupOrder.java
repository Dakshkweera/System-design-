package models;

import java.util.List;

public class PickupOrder extends Order {
    private String restaurantAddress;

    public PickupOrder(String orderId, User user, List<MenuItem> items, double totalAmount, String restaurantAddress) {
        super(orderId, user, items, totalAmount);
        this.restaurantAddress = restaurantAddress;
    }

    @Override
    public String getOrderType() {
        return "PICKUP at: " + this.restaurantAddress;
    }
}