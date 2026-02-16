package com.mcnz.rps.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score") // Base path for all methods in this class
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@GetMapping // Maps to GET /score
	public Score getScore() {
		return scoreRepository.findScore();
	}

	@GetMapping("/wins") // Maps to GET /score/wins
	public int getWins() {
		return scoreRepository.findScore().getWins();
	}

	@PostMapping("/wins") // Maps to POST /score/wins
	public boolean increaseWins() {
		Score score = scoreRepository.findScore();
		score.increaseWins();
		scoreRepository.save(score);
		return true;
	}

	// Repeat same pattern for /losses and /ties...
}