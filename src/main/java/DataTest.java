import dataAccess.DataBaseHandler;
import dataAccess.OrdersControl;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class DataTest {
    public static void main(String[] args) {
        OrdersControl ordersControl = new DataBaseHandler();

     //   ordersControl.createOrder(new Order(1, "caca", 3.4f, true));

        System.out.println(ordersControl.getAll());

      //  ordersControl.deleteOrder(13);

     //   ordersControl.updateOrder(new Order(4, "semen", 3.1f, false));

        List<Order> orderList = new ArrayList<>();

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


        for (Order order : orderList) {
            ordersControl.createOrder(order);
        }

        System.out.println(ordersControl.getAll());
    }
}
