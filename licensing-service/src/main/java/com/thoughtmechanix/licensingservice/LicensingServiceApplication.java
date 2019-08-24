package com.thoughtmechanix.licensingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient //The @EnableDiscoveryClient annotation is the trigger for Spring Cloud
// to enable the application to use the DiscoveryClient and Ribbon libraries
public class LicensingServiceApplication {

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		// that will create the Ribbon-backed Spring RestTemplate bean. @LoadBalanced makes it.
		// for this one the @EnableFeignClients and @EnableDiscoveryClient
		// annotations are not required.
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(LicensingServiceApplication.class, args);
	}

}
