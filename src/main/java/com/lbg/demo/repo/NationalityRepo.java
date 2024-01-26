package com.lbg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Nationality;

public interface NationalityRepo extends JpaRepository<Nationality, Integer> {

}
