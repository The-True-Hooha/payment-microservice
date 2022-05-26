package com.github.TheTrueHooha.PaymentService;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentModel {

    @Id
    @SequenceGenerator(name = "payment_id_sequence", sequenceName = "payment_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_sequence")
    private Integer paymentId;

    private String paymentStatus;

    private String transactionId;

    private int orderId;

    private double amount;
}
