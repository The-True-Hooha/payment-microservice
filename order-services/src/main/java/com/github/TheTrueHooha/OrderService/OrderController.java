package com.github.TheTrueHooha.OrderService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/new-order")
    public void makeAnOrder(@RequestBody OrderRequest orderRequest){
        log.info("requesting new order{}", orderRequest);
        orderService.saveNewOrder(orderRequest);
    }
}
