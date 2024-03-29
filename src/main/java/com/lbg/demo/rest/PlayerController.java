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

import com.lbg.demo.domain.PlayerDetails;
import com.lbg.demo.services.PlayerService;

@RestController
@RequestMapping("/playerDetails")
public class PlayerController {

	private PlayerService service;

	public PlayerController(PlayerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<PlayerDetails> createPlayer(@RequestBody PlayerDetails newPlayer) {
		return this.service.createPlayer(newPlayer);
	}

	@GetMapping("/get")
	public List<PlayerDetails> getPlayer() {
		return this.service.getPlayer();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PlayerDetails> getPlayer(@PathVariable int id) {
		return this.service.getPlayer(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePlayer(@PathVariable int id) {
		return this.service.deletePlayer(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<PlayerDetails> updatePlayer(@PathVariable int id, @RequestBody PlayerDetails newPlayer) {
		return this.service.updatePlayer(id, newPlayer);
	}

}
