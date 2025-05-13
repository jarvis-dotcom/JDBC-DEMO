package com.demo.SpringBootJDBC.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "employee")
@Data
public class QueryConfig {
    String insert;
    String findAll;
    String deleteAll;
    String findById;
}
