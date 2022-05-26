package com.github.TheTrueHooha.OrderService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SharedPaymentModel {

    private Integer paymentId;

    private String paymentStatus;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_sequence")
    private String transactionId;

    private Integer orderId;

    private int orderSize;

    private double amount;
}
