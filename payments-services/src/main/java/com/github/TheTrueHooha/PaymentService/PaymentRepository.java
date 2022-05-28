package com.github.TheTrueHooha.PaymentService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Integer> {

    //method to find payment by orderId
    PaymentModel findPaymentByOrderId(int orderId);

    PaymentModel findOrderById(int orderId);
}
