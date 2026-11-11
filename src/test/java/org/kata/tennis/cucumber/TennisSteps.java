package org.kata.tennis.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.kata.tennis.TennisGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisSteps {

    private TennisGame game;

    @Given("un juego nuevo")
    public void unJuegoNuevo() {
        game = new TennisGame("player1", "player2");
    }

    @When("el jugador {int} gana {int} punto(s)")
    public void ganaPuntos(int jugador, int puntos) {
        for (int i = 0; i < puntos; i++)
            game.wonPoint("player" + jugador);
    }

    @Then("el marcador es {string}")
    public void elMarcadorEs(String esperado) {
        assertEquals(esperado, game.getScore());
    }
}
