package com.emart.zuul.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // #Allow cookies to cross domains
        config.addAllowedOrigin("*");// #The URI allowed to submit requests to this server, * means all are allowed. 
        config.addAllowedHeader("*");// #Access allowed header information, * indicates all
        config.setMaxAge(7200L);// #Cache time for pre check requests (seconds)
        config.addAllowedMethod("*");// Method to allow submission of requests, * means all are allowed
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
