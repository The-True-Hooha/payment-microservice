package com.github.TheTrueHooha.OrderService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
@RefreshScope
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    @Lazy
    private final RestTemplate restTemplate;

    @Value("${microservice.payments-microservice.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderResponse saveNewOrder(OrderRequest orderRequest) throws JsonProcessingException {
        String response = "";
        OrderModel orderModel = orderRequest.getOrderModel();
        SharedPaymentModel sharedModel = orderRequest.getSharedPaymentModel();
        sharedModel.setAmount(orderModel.getOrderTotalPrice());
        sharedModel.setOrderSize(orderModel.getOrderSize());
        sharedModel.setOrderId(orderModel.getOrderId());
        sharedModel.setTransactionId(orderModel.getTransactionId());

        logger.info("order-microservice request : {}", new ObjectMapper().writeValueAsString(orderRequest));
        //injecting a rest template call
        SharedPaymentModel sharedResponse = restTemplate.postForObject
                (ENDPOINT_URL, sharedModel, SharedPaymentModel.class);

        //response that indicates the payment status
        assert sharedResponse != null;
        response = sharedResponse.getPaymentStatus().
                equals("success")?"payment successful":"payment failed, there is an issue";

        logger.info("payment-microservice response : {}", new ObjectMapper().writeValueAsString(sharedResponse));
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