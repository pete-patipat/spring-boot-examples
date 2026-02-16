package com.mcnz.rps.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@GetMapping
	public Score getScore() {
		// JpaRepository returns an 'Optional'.
		// We'll look for ID 1, or create a new Score if it doesn't exist.
		return scoreRepository.findById(1L).orElseGet(() -> {
			Score newScore = new Score();
			return scoreRepository.save(newScore);
		});
	}

	@PostMapping("/wins")
	public boolean increaseWins() {
		Score score = getScore(); // Reuse our logic above
		score.increaseWins();
		scoreRepository.save(score); // Standard JPA save method
		return true;
	}
}