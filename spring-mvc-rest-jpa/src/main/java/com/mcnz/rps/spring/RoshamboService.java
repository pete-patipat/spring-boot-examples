package com.mcnz.rps.spring;

import org.springframework.stereotype.Service;

@Service // Instruction: "Manage this business logic as a Bean"
public class RoshamboService {

    public String determineWinner(String choice) {
        Gesture clientGesture = Gesture.valueOf(choice.toUpperCase());
        Gesture serverGesture = Gesture.ROCK; // Simple logic for now

        if (clientGesture.equals(serverGesture)) {
            return "tie";
        }

        switch (clientGesture) {
            case PAPER:
                return "win";
            case SCISSORS:
                return "losse"; // Matches your /score/losses endpoint naming
            default:
                return "tie";
        }
    }
}