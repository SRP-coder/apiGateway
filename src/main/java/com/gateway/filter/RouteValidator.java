package com.gateway.filter;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {


    //this method is for ignoring the api, it means it will not ask jwt token bypass it.
    public static final List<String> openApiEndPoints = List.of(
            "/auth/log",
            "/eureka"
            );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndPoints
                    .stream()
                    .noneMatch(uri-> request.getURI().getPath().contains(uri));

}
