package com.example.api_gateway.config;

import com.example.api_gateway.filter.AuthenticationFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

private final AuthenticationFilterFactory authenticationFilterFactory;

// Constructor để inject AuthenticationFilterFactory
public GatewayConfig(AuthenticationFilterFactory authenticationFilterFactory) {
        this.authenticationFilterFactory = authenticationFilterFactory;
}

@Bean
public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("service_user", r -> r.path("/api/v1/users/**")
                        .filters(f -> f.filter(authenticationFilterFactory.apply(new AuthenticationFilterFactory.Config())))
                        .uri("http://service-user:8081"))
                .route("service_quizz", r -> r.path("/api/v1/quizzes/**")
                        .filters(f -> f.filter(authenticationFilterFactory.apply(new AuthenticationFilterFactory.Config())))
                        .uri("http://service-quizz:8082"))
                .route("service_question", r -> r.path("/api/v1/questions/**")
                        .filters(f -> f.filter(authenticationFilterFactory.apply(new AuthenticationFilterFactory.Config())))
                        .uri("http://service-question:8083"))
                .route("service_answer", r -> r.path("/api/v1/answers/**")
                        .filters(f -> f.filter(authenticationFilterFactory.apply(new AuthenticationFilterFactory.Config())))
                        .uri("http://service-answer:8084"))
                .route("service_result", r -> r.path("/api/v1/results/**")
                        .filters(f -> f.filter(authenticationFilterFactory.apply(new AuthenticationFilterFactory.Config())))
                        .uri("http://service-result:8085"))
                // Thêm các route ở đây

                .route("service_login", r -> r.path("/api/v1/users/login")
                        .uri("http://localhost:8081"))
                .build();
}
}
