package com.springrest1.springrest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableEurekaClient
public class Springrest1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springrest1Application.class, args);
		
		
	}
//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}
//

}
