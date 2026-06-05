package models;

import java.util.List;

public class DeliveryOrder extends Order {
    private String deliveryAddress;

    public DeliveryOrder(String orderId, User user, List<MenuItem> items, double totalAmount, String deliveryAddress) {
        super(orderId, user, items, totalAmount);
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String getOrderType() {
        return "DELIVERY to: " + this.deliveryAddress;
    }
}