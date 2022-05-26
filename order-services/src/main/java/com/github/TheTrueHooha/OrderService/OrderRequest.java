package com.github.TheTrueHooha.OrderService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private OrderModel orderModel;

    private SharedPaymentModel sharedPaymentModel;
}
