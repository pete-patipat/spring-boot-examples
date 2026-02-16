package com.mcnz.rps.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
	// No code needed! JpaRepository already has:
	// .findById(id), .findAll(), .save(entity), .delete(entity)
}