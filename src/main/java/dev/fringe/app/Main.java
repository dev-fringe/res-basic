package dev.fringe.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import dev.fringe.app.config.RestTemplateConfig;

@Import({RestTemplateConfig.class})
@ComponentScan("dev.fringe.app.service")
public class Main implements InitializingBean {
	
	@Value("${url:https://api.upbit.com/v1/market/all?isDetails=false}") String url;
	@Autowired RestTemplate restTemplate;
	
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
