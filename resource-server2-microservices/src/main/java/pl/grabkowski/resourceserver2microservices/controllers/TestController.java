package pl.grabkowski.resourceserver2microservices.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController

 @RequestMapping("/resource2")
public class TestController {

    @GetMapping("/forAuthenticated")
    public Mono<String> forAuthenticated()
    {
        return Mono.just("Resource 2 server for authenticated is working");

    }

    @GetMapping ("/forAll")
    @PreAuthorize("hasRole('SCOPE_USER')")
    public Mono<String> forAll()
    {

        return Mono.just("Resource 2 server for All is working");
    }
}
