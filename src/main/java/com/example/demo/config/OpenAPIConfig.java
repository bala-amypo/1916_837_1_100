package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Vendor Compliance API",
        version = "1.0",
        description = "Vendor Document Compliance Validator"
    ),
    servers = {
        @Server(url = "https://9462.pro604cr.amypo.ai/", description = "Production server")
    }
)
public class OpenAPIConfig { }
