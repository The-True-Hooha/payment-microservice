package com.github.TheTrueHooha.OrderService;

public record OrderRequest(
        String orderRecipient,
        Integer orderSize,
        double orderTotalPrice
) {
}
