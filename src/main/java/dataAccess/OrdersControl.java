package dataAccess;

import model.Order;

import java.util.List;

public interface OrdersControl {
    void createOrder(Order order);
    List<Order> getAll();
    Order getOrder(int id);
    void updateOrder(Order order);
    void deleteOrder(int id);
}
