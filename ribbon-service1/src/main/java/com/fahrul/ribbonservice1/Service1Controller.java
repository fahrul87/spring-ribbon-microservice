package com.fahrul.ribbonservice1;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service1Controller {
	
	@Autowired
	private LoadBalancerClient LoadBalancerClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping
	public String welcome() {
		
		ServiceInstance instance = LoadBalancerClient.choose("service2");
		URI uri = URI.create(String.format("http://%s:%s/", instance.getHost(),instance.getPort()));
		return "Welcome to Service 1, Service 2 (URI :"+ uri+" Respone :" 
				+ restTemplate.getForObject("http://localhost:9092/", String.class);
		
	}

}
