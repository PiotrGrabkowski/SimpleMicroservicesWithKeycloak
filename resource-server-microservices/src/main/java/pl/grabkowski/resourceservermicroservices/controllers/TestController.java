package pl.grabkowski.resourceservermicroservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/resource1")
public class TestController {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public TestController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping ("/resourceTest")
            public Mono<String> resourceTest()
    {
        return webClientBuilder.build()
                .get()
                .uri("http://resource2-server/resource2Test")
                .retrieve()
                .bodyToMono(String.class);


    }
    @GetMapping ("/forAll")
    public Mono<String> forAll()
    {
        return Mono.just("resource 1 for all is working");
    }
}
