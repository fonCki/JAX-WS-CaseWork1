package service;

import model.Order;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
public interface ManageOrderService {
     @WebMethod String getList();

     @WebMethod void AddOrder(@WebParam(name = "id") int id,
                              @WebParam(name = "description") String description,
                              @WebParam(name = "amount") float amout,
                              @WebParam(name = "delivered") boolean delivered);

     @WebMethod String getOrder(@WebParam(name = "id") int id);

     @WebMethod void updateOrder(@WebParam(name = "id") int id,
                                        @WebParam(name = "description") String description,
                                        @WebParam(name = "amount") float amount,
                                        @WebParam(name = "delivered") boolean delivered);

     @WebMethod void deleteOrder(@WebParam(name = "id") int id);

}