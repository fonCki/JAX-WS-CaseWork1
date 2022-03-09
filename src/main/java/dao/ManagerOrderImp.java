package dao;

import dataAccess.DataBaseHandler;
import dataAccess.OrdersControl;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManagerOrderImp implements ManageOrder<Order>{

    OrdersControl ordersControl = new DataBaseHandler();

    @Override
    public Order get(int id) {
        return ordersControl.getOrder(id);
    }

    @Override
    public List<Order> getAll() {
        return ordersControl.getAll();
    }

    @Override
    public void create(Order order) {
        ordersControl.createOrder(order);
    }

    @Override
    public void update(Order order) {
        ordersControl.updateOrder(order);
    }


    @Override
    public void delete(Order order) {
        ordersControl.deleteOrder(order.getId());
    }

    @Override
    public void delete(int id) {
        ordersControl.deleteOrder(id);
    }
}
