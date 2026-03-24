package com.eazybytes.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

    @Bean
    public RouteLocator pacoBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(p->p
                        .path("/pacobank/accounts/**")
                        .filters(f->f.rewritePath("/pacobank/accounts/(?<remaining>.*)","/${remaining}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("accountsCircuitBreaker")
                                        .setFallbackUri("forward:/contactSupport")))
                        .uri("lb://ACCOUNTS")) //Application name showed in Eureka Server Dashboard
                .route(p->p
                    .path("/pacobank/loans/**")
                    .filters(f->f.rewritePath("/pacobank/loans/(?<remaining>.*)","/${remaining}")
                            .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                    .uri("lb://LOANS"))
                .route(p->p
                    .path("/pacobank/cards/**")
                    .filters(f->f.rewritePath("/pacobank/cards/(?<remaining>.*)","/${remaining}")
                            .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                    .uri("lb://CARDS")).build();
    }
}
