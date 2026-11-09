package org.kata.tennis.mockito;

import org.kata.tennis.Scoreboard;

import java.util.ArrayList;
import java.util.List;

class InMemoryScoreboard implements Scoreboard {

    private final List<String> displayedScores = new ArrayList<>();

    @Override
    public void display(String score) {
        displayedScores.add(score);
    }

    List<String> displayedScores() {
        return List.copyOf(displayedScores);
    }

    String lastDisplayedScore() {
        return displayedScores.getLast();
    }
}
