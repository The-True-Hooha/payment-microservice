package com.github.TheTrueHooha.PaymentService;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/pay")
@Slf4j
@AllArgsConstructor
public class PaymentController {

    @Autowired
    private final PaymentService paymentService;

    @PostMapping("/pay-now")
    public PaymentModel makePayments(@RequestBody PaymentModel paymentModel) throws JsonProcessingException {
        return paymentService.saveNewPayment(paymentModel);
    }

    @GetMapping("/{get-order}")
    public PaymentModel findPaymentByOrderId(@PathVariable int orderId) throws JsonProcessingException {
        return paymentService.findPaymentRecordById(orderId);
    }

}
