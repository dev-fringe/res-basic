package dev.fringe.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * RestTemplate As of 5.0 this class is in maintenance mode, with only minor requests for changes and bugs to be accepted going forward
 * spring 5.0 release date - September 28, 2017
 */
@Configuration
public class RestTemplateConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

}
