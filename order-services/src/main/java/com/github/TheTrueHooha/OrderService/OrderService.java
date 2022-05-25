package com.github.TheTrueHooha.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderRequest orderRequest;

    public void saveNewOrder(OrderRequest orderRequest){
        OrderModel orderModel = OrderModel.builder()
                .orderSize(orderRequest.orderSize())
                .orderName(orderRequest.orderName())
                .orderPrice(orderRequest.orderPrice())
                .build();
        orderRepository.save(orderModel);
    }
}
