package com.github.TheTrueHooha.PaymentService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Integer> {
}
