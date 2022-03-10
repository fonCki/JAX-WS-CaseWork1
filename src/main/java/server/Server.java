package server;

import service.ManageOrderService;
import service.ManageOrderServiceImp;

import javax.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
    ManageOrderService service = new ManageOrderServiceImp();
    String address = "http://localhost:7777/OrderService";
        Endpoint.publish(address, service);
        System.out.println("------- the server is ready ----");
    }
}
