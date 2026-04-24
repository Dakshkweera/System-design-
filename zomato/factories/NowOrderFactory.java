package factories;

import models.*;
import java.util.UUID;

public class NowOrderFactory implements IOrderFactory {
    @Override
    public Order createOrder(User user) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        return new DeliveryOrder(
            id, 
            user, 
            user.getCart().getItems(), 
            user.getCart().calculateTotal(), 
            user.getLocation()
        );
    }
}