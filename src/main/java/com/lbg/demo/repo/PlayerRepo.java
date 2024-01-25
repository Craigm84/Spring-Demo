package com.lbg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.PlayerDetails;

public interface PlayerRepo extends JpaRepository<PlayerDetails, Integer> {

}
