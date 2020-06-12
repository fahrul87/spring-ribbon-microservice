package com.fahrul.ribbonservice3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name = "service2",configuration = RibbonConfiguration.class)
public class Service3Controller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping
	public String welcome() {
		return "Welcome to Service 3, Service 2 Response - "+restTemplate.getForObject("http://service2/",String.class);
	}

}
