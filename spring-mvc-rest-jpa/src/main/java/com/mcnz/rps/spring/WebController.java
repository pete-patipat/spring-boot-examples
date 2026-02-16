package com.mcnz.rps.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebController {

	@Autowired
	private RestTemplate restTemplate; // Inject the bean from RoshamboApplication

	@GetMapping("/playagame")
	public String playRoshambo(@RequestParam(name = "choice", required=false) String choice, Model model) {
		// ... (check for null choice)

		// Instead of result == "tie", use .equals for strings in Java!
		String result = determineWinner(choice);

		// Use the injected restTemplate for all calls
		String url = "http://localhost:8080/score/" + result + "s"; // e.g., /score/wins
		restTemplate.postForObject(url, "", Object.class);

		Score score = restTemplate.getForObject("http://localhost:8080/score", Score.class);
		model.addAttribute("score", score);

		return "results";
	}

	private String determineWinner(String choice) {
		Gesture clientGesture = Gesture.valueOf(choice.toUpperCase());
		Gesture serverGesture = Gesture.ROCK; // Hardcoded for now as per your original code

		if (clientGesture.equals(serverGesture)) {
			return "tie";
		}

		switch (clientGesture) {
			case PAPER:
				return "win";
			case SCISSORS:
				return "losse"; // Note: your endpoint is /score/losses, so ensure this matches
			case ROCK:
			default:
				return "tie";
		}
	}
}

