package com.github.TheTrueHooha.PaymentService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepository;

    private Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public PaymentModel saveNewPayment(PaymentModel paymentModel) throws JsonProcessingException {
        paymentModel.setPaymentStatus(paymentState());
        paymentModel.setTransactionId(UUID.randomUUID().toString());
        log.info("adding new payment to the database");
        logger.info("payment-microservice request : {}", new ObjectMapper().writeValueAsString(paymentModel));
        return paymentRepository.save(paymentModel);
    }

    //code that verifies if the payment is successful or not. TODO: replace with payment api
    public String paymentState(){
        return new Random().nextBoolean()?"success" : "false";
    }

    //method to find the payment record by id
    public PaymentModel findPaymentRecordById(int orderId) throws JsonProcessingException {
        PaymentModel payment = paymentRepository.findOrderById(orderId);
        logger.info("payment-microservice findPaymentRecordById : {}", new ObjectMapper().writeValueAsString(payment));
        return payment;
    }
    //todo: if changes are successful, generate a payment Id, and not transaction Id
    //TODO: unsuccessful payments will still retain their orderId
    //TODO: add payment verification status with Google Pay platform
}
