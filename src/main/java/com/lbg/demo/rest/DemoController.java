package com.lbg.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World";
	}

	@GetMapping("/yo")
	public String greeting1() {
		return "Yo, World";
	}

}
