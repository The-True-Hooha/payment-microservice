package com.github.TheTrueHooha.ServiceGateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ServiceGatewayController {

    @RequestMapping("/order-failed/redirect")
    public Mono<String> orderFailureRedirect(){
        return Mono.just("sorry, can't send in orders at the moment, service is down or please try again later");
    }

    @RequestMapping("/payment-failed/redirect")
    public Mono<String> paymentFailureRedirect(){
        return Mono.just("sorry, can't make payments at the moment, service is down or please try again later");
    }

}
