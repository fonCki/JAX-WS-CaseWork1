package dao;

import model.Order;

import java.util.List;
import java.util.Optional;

public interface ManageOrder<T> {
    Order get(int id);
    List<T> getAll();
    void create(T t);
    void update(T t);
    void delete(T t);
    void delete (int id);
}
