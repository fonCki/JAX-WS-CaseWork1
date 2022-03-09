package server;

import dao.ManageOrder;
import dao.ManagerOrderImp;
import model.Order;
import service.ManageOrderService;
import service.ManageOrderServiceImp;

import javax.xml.ws.Endpoint;

public class Server {
    /*
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:7777/OrderService/getall", new ManagerOrderImp());
        System.out.println("-server ready-");

     */
    public static void main(String[] args) {
    ManageOrderService service = new ManageOrderServiceImp();
    String address = "http://localhost:7777/OrderService";
        Endpoint.publish(address, service);
        System.out.println("------- the server is ready ----");
    }
}
