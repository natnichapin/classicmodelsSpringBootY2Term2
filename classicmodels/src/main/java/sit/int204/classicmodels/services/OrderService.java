package sit.int204.classicmodels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodels.Models.Order;
import sit.int204.classicmodels.Repositories.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository ;

    public List<Order> getAllOrders (){
        return repository.findAll();
    }



}
