package pl.grabkowski.resourceservermicroservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class Securityconfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){

        http.csrf().disable();
        http.authorizeExchange(exchange -> exchange.anyExchange().authenticated())
        .oauth2ResourceServer(auth ->auth.jwt());
        return http.build();
    }
}
