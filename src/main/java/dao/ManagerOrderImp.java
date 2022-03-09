package dao;

import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManagerOrderImp implements ManageOrder<Order>{

    List<Order> orderList = new ArrayList<Order>();

    public ManagerOrderImp() {
        orderList.add(new Order(1,"Hamburguer", 25.5f, true));
        orderList.add(new Order(2,"smorrebrood", 12.2f, true));
        orderList.add(new Order(3,"Pizza", 11.0f, true));
        orderList.add(new Order(4,"Pasta", 12.5f, true));
        orderList.add(new Order(5,"Salad", 30.2f, true));
        orderList.add(new Order(6,"Pita", 12.3f, true));
        orderList.add(new Order(7,"Kebab", 21.3f, true));
        orderList.add(new Order(8,"Burrito", 20.5f, true));
        orderList.add(new Order(9,"Phily Cheese", 12.7f, true));
        orderList.add(new Order(10,"Empanadas", 17.5f, true));
    }

    @Override
    public Order get(int id) {
        return  orderList.stream()
                .filter(o -> o.getId() == id)
                .findAny()
                .orElse(new Order(-1, "NOT FOUND", 0, false));
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }

    @Override
    public void create(Order order) {
        orderList.add(order);
    }

    @Override
    public void update(Order order) {
        delete(get(order.getId()));
        create(order);
    }


    @Override
    public void delete(Order order) {
        orderList.remove(order);
    }

    @Override
    public void delete(int id) {
        orderList.removeIf(i-> i.getId() == id);
    }
}
