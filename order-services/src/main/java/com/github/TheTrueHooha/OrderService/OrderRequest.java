package com.github.TheTrueHooha.OrderService;

public record OrderRequest(
        String orderName,
        Integer orderSize,
        double orderPrice
) {
}
