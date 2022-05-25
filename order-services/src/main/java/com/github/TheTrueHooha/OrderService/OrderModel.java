package com.github.TheTrueHooha.OrderService;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class OrderModel {

    @Id
    @SequenceGenerator(name = "order_id_sequence", sequenceName = "order_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_sequence")
    private Integer orderId;

    private String orderRecipient;

    private Integer orderSize;

    private double orderTotalPrice;
}
