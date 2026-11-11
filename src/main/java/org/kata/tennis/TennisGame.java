package org.kata.tennis;

import java.util.Map;

public class TennisGame {

    private static final String DEFAULT_PLAYER_ONE_NAME = "player1";
    private static final String DEFAULT_PLAYER_TWO_NAME = "player2";
    private static final String UNKNOWN_PLAYER_MESSAGE = "Unknown player: ";

    private final String player1Name;
    private final String player2Name;

    int player1Score;
    int player2Score;

    public TennisGame() {
        this(DEFAULT_PLAYER_ONE_NAME, DEFAULT_PLAYER_TWO_NAME);
    }

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            player1Scores();
            return;
        }
        if (player2Name.equals(playerName)) {
            player2Scores();
            return;
        }
        throw new IllegalArgumentException(UNKNOWN_PLAYER_MESSAGE + playerName);
    }

    Map<Integer, String> scoring = Map.of(
            0,"love",
            1, "fifteen",
            2, "thirty",
            3, "forty"
    );

    public String getScore() {
        String p1Score = scoring.get(player1Score);
        String p2Score = scoring.get(player2Score);

        if(player1Score == 3 && player2Score == 3)
            return "deuce";

        return p1Score + "-" + p2Score;
    }

    public void player1Scores() {
        player1Score++;
    }

    public void player2Scores() {
        player2Score++;
    }
}
