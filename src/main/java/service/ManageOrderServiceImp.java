package service;

import dao.ManageOrder;
import dao.ManagerOrderImp;
import jsonConverter.JsonConverter;
import model.Order;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

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
    public void AddOrder(int id, String description, float amout, boolean delivered) {
        manageOrder.create(new Order(id,description,amout,delivered));
    }

    @Override
    public String getOrder(int id) {
        return JsonConverter.toJson(manageOrder.get(id));
    }

}