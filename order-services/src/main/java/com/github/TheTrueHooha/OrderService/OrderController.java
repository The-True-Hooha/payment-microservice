package com.github.TheTrueHooha.OrderService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/order")
@AllArgsConstructor

public class OrderController {

    @Autowired
    private final OrderService orderService;

    @PostMapping("/new-order")
    public OrderResponse makeAnOrder(@RequestBody OrderRequest orderRequest){
        log.info("requesting new order{}", orderRequest);
        return orderService.saveNewOrder(orderRequest);

    }
}
