package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Nationality;
import com.lbg.demo.repo.NationalityRepo;

@Service
public class NationalityService {

	private NationalityRepo repo;

	public NationalityService(NationalityRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Nationality> createCountry(Nationality newCountry) {
		Nationality created = this.repo.save(newCountry);
		return new ResponseEntity<Nationality>(created, HttpStatus.CREATED);
	}

	public List<Nationality> getCountry() {
		return repo.findAll();
	}

	public ResponseEntity<Nationality> getCountry(int id) {
		Optional<Nationality> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Nationality>(HttpStatus.NOT_FOUND);
		}
		Nationality body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deleteCountry(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public ResponseEntity<Nationality> updateCountry(int id, Nationality newNationality) {
		Optional<Nationality> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Nationality>(HttpStatus.NOT_FOUND);
		}
		Nationality existing = found.get();

		if (newNationality.getCountry() != null) {
			existing.setCountry(newNationality.getCountry());
		}

		if (newNationality.getContinent() != null) {
			existing.setContinent(newNationality.getContinent());
		}

		Nationality updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

}
