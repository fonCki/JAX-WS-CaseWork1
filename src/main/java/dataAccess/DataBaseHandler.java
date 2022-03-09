package dataAccess;

import model.Order;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler implements OrdersControl{

    private Connection connection = DataConnection.getInstance().getConnection();

    @Override
    public void createOrder(Order order) {
         String START_QUERY = "INSERT INTO";
         String SCHEMA_AND_TABLE = "\"" + DataConnection.SCHEMA + "\".orders";
         String QUERY_FIELD = "(description, amount, delivered) VALUES (?,?,?)";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(START_QUERY + SCHEMA_AND_TABLE + QUERY_FIELD);
                preparedStatement.setString(1, order.getDescription());
                preparedStatement.setFloat(2, order.getAmount());
                preparedStatement.setBoolean(3, order.isDelivered());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public List<Order> getAll() {
        List<Order> orderList= new ArrayList<>();
        String query = "SELECT * FROM \"" + DataConnection.SCHEMA + "\"." + "orders";
        try {
            ResultSet resultSet = getFromDatabase(query);
            do {
                orderList.add(createOrd(resultSet));
            } while (resultSet.next());
        } catch (SQLException e) {
            return orderList;
        }
        return orderList;
    }



    @Override
    public Order getOrder(int id) {
        String query = "SELECT * FROM \"" + DataConnection.SCHEMA + "\"." + "orders" + " WHERE order_id = '" + id + "'";

        try {
            ResultSet resultSet = getFromDatabase(query);
            return createOrd(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOrder(Order order) {
        String query = "UPDATE \"" + DataConnection.SCHEMA + "\"." + "orders" + " SET description = ?, amount = ?, delivered = ? WHERE order_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,order.getDescription());
            preparedStatement.setFloat(2,order.getAmount());
            preparedStatement.setBoolean(3,order.isDelivered());

            preparedStatement.setObject(4, order.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id) {
        String query = "DELETE FROM \"" + DataConnection.SCHEMA + "\".orders WHERE order_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private ResultSet getFromDatabase(String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet;
    }

    private Order createOrd(ResultSet resultSet) throws SQLException {
        return new Order(resultSet.getInt("order_id"),
                         resultSet.getString("description"),
                         resultSet.getFloat("amount"),
                         resultSet.getBoolean("delivered"));
    }

}
