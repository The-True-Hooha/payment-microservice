package com.github.TheTrueHooha.CustomerService;

public record CustomerRequest(
        String customerName,
        String customerAddress,
        String customerPhoneNumber
) {
}
