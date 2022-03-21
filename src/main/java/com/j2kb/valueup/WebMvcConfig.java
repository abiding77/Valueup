package com.j2kb.valueup;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://183.109.87.229:8080")
                .allowedMethods("OPTIONS","GET","POST","PATCH","DELETE");
    }
}
