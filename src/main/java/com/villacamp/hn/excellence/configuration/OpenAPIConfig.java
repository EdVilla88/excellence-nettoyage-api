package com.villacamp.hn.excellence.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

//    @Value("${server.base.path:http://localhost:8080}")
//    private String serverBasePath;

    @Bean
    public OpenAPI buildOpenAPIServerList() {
//        Server server = new Server();
//        server.url(serverBasePath);
//        server.description("server");

        Contact contact = new Contact();
        contact.setEmail("efvc88@hotmail.com");
        contact.setName("Edwin Villanueva");
//        contact.setUrl("");

        Info info = new Info()
                .title("Excellence Nettoyage")
                .version("v0.0.7")
                .contact(contact)
                .description("Excellence's API");

        return new OpenAPI()
                .info(info);
//                .servers(List.of(server));
    }
}
