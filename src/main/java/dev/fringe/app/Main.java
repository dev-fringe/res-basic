package dev.fringe.app;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import dev.fringe.app.supprt.ApiRestLoggingRequestInterceptor;

public class Main implements InitializingBean {
	
	@Value("${url:https://api.upbit.com/v1/market/all?isDetails=false}") String url;
	@Autowired RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new ApiRestLoggingRequestInterceptor()));
		return restTemplate;
	}
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(Main.class);
	}
	public void afterPropertiesSet() throws Exception {
		List<Map<String, Object>> list = restTemplate.getForObject(url, List.class);
		for (Map<String, Object> market : list) {
			System.out.println(market);
		}
//		log.info("done");
	}
}
