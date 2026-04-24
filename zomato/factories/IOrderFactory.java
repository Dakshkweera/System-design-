package factories;

import models.Order;
import models.User;

public interface IOrderFactory {
    Order createOrder(User user);
}