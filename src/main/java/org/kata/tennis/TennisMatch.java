package org.kata.tennis;

public class TennisMatch {

    private final TennisGame game;
    private final HawkEye hawkEye;
    private final Scoreboard scoreboard;

    public TennisMatch(TennisGame game, HawkEye hawkEye, Scoreboard scoreboard) {
        this.game = game;
        this.hawkEye = hawkEye;
        this.scoreboard = scoreboard;
    }

    public void resolvePlayerOneShot() {
        awardPointAfterPlayerOneShot();
        scoreboard.display(game.getScore());
    }

    public String score() {
        return game.getScore();
    }

    private void awardPointAfterPlayerOneShot() {
        if (hawkEye.isBallIn()) {
            game.player1Scores();
            return;
        }
        game.player2Scores();
    }
}
