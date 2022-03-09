package jsonConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Order;

import java.util.List;
import java.util.function.ObjDoubleConsumer;

public class JsonConverter {
    public static String toJson(Order order) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(order);
    }

    public static String toJson(List<Order> orderList) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(orderList);
    }

    public static Order fromJsonToOrder(String orderJson) {
        return new Gson().fromJson(orderJson, Order.class);
    }

    public static Order fromJsonToOrderList(String orderJson) {
        return new Gson().fromJson(orderJson, new TypeToken<List<Order>>() {}.getType());
    }

}
