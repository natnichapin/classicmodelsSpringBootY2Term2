package sit.int204.classicmodels.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.classicmodels.Models.Order;
import sit.int204.classicmodels.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService service ;

    @GetMapping("")
    public List<Order> getOrders(){
        return  service.getAllOrders();
    }
}
