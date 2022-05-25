package com.github.TheTrueHooha.PaymentService;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepository;

    public PaymentModel addNewPayment(PaymentModel paymentModel){
        paymentModel.setTransactionId(UUID.randomUUID().toString());
        log.info("adding new payment to the database");
        return paymentRepository.save(paymentModel);
    }
}
