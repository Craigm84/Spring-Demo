package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Player;

@RestController
public class DemoController {

	private List<Player> players = new ArrayList<>();

	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World";
	}

	@GetMapping("/yo")
	public String greeting1() {
		return "Yo, World";
	}

	@PostMapping("/create")
	public ResponseEntity<Player> createPlayer(@RequestBody Player newPlayer) {
		this.players.add(newPlayer);
//		return players.toString();
		Player body = this.players.get(this.players.size() - 1);
		return new ResponseEntity<Player>(body, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<Player> getPlayer() {
		return players;

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Player> getPlayer(@PathVariable int id) {
		if (id < 0 || id >= this.players.size()) {
			return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
		}
		Player found = this.players.get(id);
		return ResponseEntity.ok(found);
	}

	@DeleteMapping("/delete/{id}")
	public Player deletePlayer(@PathVariable int id) {
		return this.players.remove(id);
	}

	@PutMapping("/update/{id}")
	public Player updatePlayer(@PathVariable int id, @RequestBody Player newPlayer) {
		this.players.get(id);
		return this.players.set(id, newPlayer);
	}

	@PatchMapping("/patchupdate/{id}")
	public Player update(@PathVariable int id, @RequestBody String Club) {
		this.players.get(id).setClub(Club);
		return this.players.get(id);
	}

}
