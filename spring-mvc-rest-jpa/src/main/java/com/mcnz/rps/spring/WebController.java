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
	private RestTemplate restTemplate;

	@Autowired // INJECT the new logic bean
	private RoshamboService roshamboService;

	@GetMapping("/playagame")
	public String playRoshambo(@RequestParam(name = "choice", required=false) String choice, Model model) {
		if (choice == null) return "index";

		// Ask the Service to do the math/logic
		String result = roshamboService.determineWinner(choice);

		// Update score via REST
		String url = "http://localhost:8080/score/" + result + "s";
		restTemplate.postForObject(url, "", Object.class);

		// Get updated score to show Pete the results
		Score score = restTemplate.getForObject("http://localhost:8080/score", Score.class);

		model.addAttribute("score", score);
		return "results";
	}
}