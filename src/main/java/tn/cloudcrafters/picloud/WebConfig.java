package tn.cloudcrafters.picloud;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/{spring:[\\w-]+}")
                .setViewName("forward:/index.html");
        registry.addViewController("/{spring:[\\w-]+}/{spring2:[\\w-]+}")
                .setViewName("forward:/index.html");
        registry.addViewController("/{spring:[\\w-]+}/{spring2:[\\w-]+}/{spring3:[\\w-]+}")
                .setViewName("forward:/index.html");
        // Ajoute d'autres si besoin
    }
}
