package com.villacamp.hn.excellence;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecuritySchemes({
        @SecurityScheme(
                name = "api-key",
                scheme = "ApiKeyAuth",
                type = SecuritySchemeType.APIKEY,
                in = SecuritySchemeIn.HEADER),
        @SecurityScheme(
                name = "Authorization",
                scheme = "bearer",
                type = SecuritySchemeType.HTTP,
                in = SecuritySchemeIn.HEADER)})
public class ExcellenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcellenceApplication.class, args);
    }

}
