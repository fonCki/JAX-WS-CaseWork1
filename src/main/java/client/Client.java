package client;

import service.ManageOrderService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        URL WSDL_URL = new URL("http://localhost:7777/OrderService?wsdl");
        QName SERVICE_NAME = new QName("http://service/", "ManageOrderService");


        Service service = Service.create(WSDL_URL, SERVICE_NAME);
        System.out.println("SOAP service is now created");

        ManageOrderService manageOrderService = service.getPort(ManageOrderService.class);
        // TEST GET ALL
        System.out.println(manageOrderService.getList());
    }
}
