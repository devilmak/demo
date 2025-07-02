package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Forward any paths that do NOT contain a dot (.) to index.html
        registry.addViewController("/{path:[^\\.]*}")
                .setViewName("forward:/index.html");

        registry.addViewController("/{path:^(?!.*\\\\.).*}")
                .setViewName("forward:/index.html");
    }
}
