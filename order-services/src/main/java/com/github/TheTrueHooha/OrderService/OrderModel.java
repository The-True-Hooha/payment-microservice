package com.github.TheTrueHooha.OrderService;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class OrderModel {

    @Id
    @SequenceGenerator(name = "order_id_sequence", sequenceName = "order_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_sequence")
    private Integer orderId;

    private String orderRecipient;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_sequence")
    private String transactionId;

    private int orderSize;

    private double orderTotalPrice;

    //todo:add model for item name
}
