package com.github.TheTrueHooha.PaymentService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/pay")
@Slf4j
@AllArgsConstructor
public class PaymentController {

    @Autowired
    private final PaymentService paymentService;

    @PostMapping("/pay-now")
    public PaymentModel makePayments(@RequestBody PaymentModel paymentModel){
        return paymentService.addNewPayment(paymentModel);
    }
}
