package com.github.TheTrueHooha.PaymentService;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
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

    public PaymentModel saveNewPayment(PaymentModel paymentModel){
        paymentModel.setPaymentStatus(paymentState());
        paymentModel.setTransactionId(UUID.randomUUID().toString());
        log.info("adding new payment to the database");
        return paymentRepository.save(paymentModel);
    }

    //TODO: add payment verification status with Google Pay platform

    public String paymentState(){
        return new Random().nextBoolean()?"success" : "false";
    }
}
