package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.PlayerDetails;
import com.lbg.demo.repo.PlayerRepo;

@Service
public class DemoService {

	@Autowired
	private PlayerRepo repo;

	public ResponseEntity<PlayerDetails> createPlayer(PlayerDetails newPlayer) {
		PlayerDetails created = this.repo.save(newPlayer);
		return new ResponseEntity<PlayerDetails>(created, HttpStatus.CREATED);
	}

	public List<PlayerDetails> getPlayer() {
		return this.repo.findAll();
	}

	public ResponseEntity<PlayerDetails> getPlayer(int id) {
		Optional<PlayerDetails> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<PlayerDetails>(HttpStatus.NOT_FOUND);
		}
		PlayerDetails body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deletePlayer(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public ResponseEntity<PlayerDetails> updatePlayer(int id, PlayerDetails newPlayer) {
		Optional<PlayerDetails> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<PlayerDetails>(HttpStatus.NOT_FOUND);
		}
		PlayerDetails existing = found.get();

		if (newPlayer.getPlayer() != null) {
			existing.setPlayer(newPlayer.getPlayer());
		}

		if (newPlayer.getClub() != null) {
			existing.setClub(newPlayer.getClub());
		}

		PlayerDetails updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

}
