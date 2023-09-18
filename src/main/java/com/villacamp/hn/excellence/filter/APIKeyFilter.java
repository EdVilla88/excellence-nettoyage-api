package com.villacamp.hn.excellence.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@Order(1)
public class APIKeyFilter extends OncePerRequestFilter {

    @Value("${en.app.apiKey}")
    private String API_KEY;
    @Autowired
    private Environment environment;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader("api-key");
        if (Objects.nonNull(apiKey) && isValid(apiKey) ||
                request.getRequestURI().contains("/actuator/health") ||
                request.getRequestURI().contains("/v3/api-docs") ||
                request.getRequestURI().contains("/swagger-ui"))
            filterChain.doFilter(request, response);
        else
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    private boolean isValid(String apiKey) {
        return apiKey.equals(API_KEY);
    }

    @EventListener(classes = ContextRefreshedEvent.class)
    private boolean checkEnvironment() {
        return Objects.equals(environment.getProperty("spring.profiles.active"), "dev");
    }
}
