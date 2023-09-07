package com.villacamp.hn.excellence.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebApplicationConfiguration implements WebMvcConfigurer {

    @Value("${not.found.url}")
    private String redirectURL;

    @Value("${server.base.path:http://localhost:8080}")
    private String serverBasePath;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/notFound").setViewName("redirect:" + redirectURL);
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
        return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notFound"));
        };
    }

    @Bean
    public OpenAPI buildOpenAPIServerList() {
        OpenAPI openAPI = new OpenAPI();
        Server server = new Server();
        server.url(serverBasePath);
        server.description("server");
        openAPI.setServers(List.of(server));
        return openAPI;
    }
}
