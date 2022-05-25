package com.github.TheTrueHooha.OrderService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final OrderRequest orderRequest;

    public void saveNewOrder(OrderRequest orderRequest){
        OrderModel orderModel = OrderModel.builder()
                .orderSize(orderRequest.orderSize())
                .orderRecipient(orderRequest.orderRecipient())
                .orderTotalPrice(orderRequest.orderTotalPrice())
                .build();
        orderRepository.save(orderModel);
    }
}
