package pl.grabkowski.gatewaymicroservices.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
       return routeLocatorBuilder.routes()
                .route(r -> r.path("/resource2/*")
                        .filters(h ->h.tokenRelay())


                        .uri("http://localhost:7171/resource2"))
                .build();



    }
}
