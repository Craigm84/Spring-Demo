package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Nationality;
import com.lbg.demo.services.NationalityService;

@RestController
@RequestMapping("/nationality")
public class NationalityController {

	private NationalityService service;

	public NationalityController(NationalityService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Nationality> createCountry(@RequestBody Nationality newCountry) {
		return this.service.createCountry(newCountry);
	}

	@GetMapping("/get")
	public List<Nationality> getCountry() {
		return this.service.getCountry();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Nationality> getCountry(@PathVariable int id) {
		return this.service.getCountry(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteCountry(@PathVariable int id) {
		return this.service.deleteCountry(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Nationality> updateCountry(@PathVariable int id, @RequestBody Nationality newCountry) {
		return this.service.updateCountry(id, newCountry);
	}

}
