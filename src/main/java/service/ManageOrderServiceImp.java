package service;

import dao.ManageOrder;
import dao.ManagerOrderImp;
import jsonConverter.JsonConverter;
import model.Order;

import javax.jws.WebService;


@WebService(endpointInterface = "service.ManageOrderService", serviceName = "ManageOrderService")
public class ManageOrderServiceImp implements ManageOrderService{

    ManageOrder<Order> manageOrder;

    public ManageOrderServiceImp() {
        if (manageOrder == null) {
            manageOrder = new ManagerOrderImp();
        }
    }

    @Override
    public String getList() {
        return JsonConverter.toJson(manageOrder.getAll());
    }

    @Override
    public void AddOrder(String description, float amout, boolean delivered) {
        manageOrder.create(new Order(description,amout,delivered));
    }

    @Override
    public String getOrder(int id) {
        return JsonConverter.toJson(manageOrder.get(id));
    }

    @Override
    public void updateOrder(int id, String description, float amount, boolean delivered) {
        manageOrder.update(new Order(id, description, amount, delivered));
    }

    @Override
    public void deleteOrder(int id) {
        manageOrder.delete(id);
    }

}
