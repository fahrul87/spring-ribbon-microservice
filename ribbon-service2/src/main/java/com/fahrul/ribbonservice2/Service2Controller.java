package com.fahrul.ribbonservice2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service2Controller {
	
	@GetMapping
	public String welcome() {
		return "Welcome to Service 2";
	}

}
