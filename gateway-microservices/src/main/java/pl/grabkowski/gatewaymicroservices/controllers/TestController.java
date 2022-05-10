package pl.grabkowski.gatewaymicroservices.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @GetMapping("/test/auth")
    public Mono<String> forAuthenticated(){

        return Mono.just("For authenticated test successfull");
    }
}
