package com.github.TheTrueHooha.OrderService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private OrderModel orderModel;
    private String transactionId;
    private double amount;
    private int orderSize;
    private String message;
}
