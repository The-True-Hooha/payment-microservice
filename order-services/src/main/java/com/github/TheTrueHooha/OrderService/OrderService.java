package com.github.TheTrueHooha.OrderService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final RestTemplate restTemplate;

    public OrderResponse saveNewOrder(OrderRequest orderRequest){
        String response = "";
        OrderModel orderModel = orderRequest.getOrderModel();
        SharedPaymentModel sharedModel = orderRequest.getSharedPaymentModel();
        sharedModel.setAmount(orderModel.getOrderTotalPrice());
        sharedModel.setOrderSize(orderModel.getOrderSize());
        sharedModel.setOrderId(orderModel.getOrderId());
        sharedModel.setTransactionId(orderModel.getTransactionId());

        //injecting a rest template call
        SharedPaymentModel sharedResponse = restTemplate.postForObject("http://localhost:4200/api/v1/pay/pay-now",
                sharedModel, SharedPaymentModel.class);

        //response that indicates the payment status
        assert sharedResponse != null;
        response = sharedResponse.getPaymentStatus().
                equals("success")?"payment successful":"payment failed, there is an issue";

        log.info("saving new order to the database");
        orderRepository.save(orderModel);

        return new OrderResponse(orderModel,
                sharedModel.getTransactionId(),
                sharedModel.getAmount(),
                sharedModel.getOrderSize(),
                response);
    }

}


//todo:fix transaction Id to be auto generated
//todo:will perhaps come with the implemented payment api gateway
//todo:let the orderId match the payment Id, and transaction Id be a generated string