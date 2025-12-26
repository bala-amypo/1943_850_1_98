package com.example.demo.config;

import com.example.demo.servlet.SimpleStatusServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    /**
     * Registers SimpleStatusServlet.
     * Tests invoke servlet directly, but this keeps
     * the configuration complete and correct.
     */
    @Bean
    public ServletRegistrationBean<SimpleStatusServlet> simpleStatusServlet() {
        return new ServletRegistrationBean<>(
                new SimpleStatusServlet(),
                "/status"
        );
    }
}