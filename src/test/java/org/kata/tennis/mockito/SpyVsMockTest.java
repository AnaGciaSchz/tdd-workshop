package org.kata.tennis.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kata.tennis.TennisGame;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@DisplayName("6. Spy frente a Mock: el mismo escenario con los dos")
class SpyVsMockTest {

    @Test
    @DisplayName("Spy de TennisGame: el punto se suma de verdad y el marcador es fifteen-love")
    void spyGameExecutesRealBehaviour() {
        // Arrange
        TennisGame game = spy(new TennisGame());

        // Act
        game.player1Scores();

        // Assert
        assertEquals("fifteen-love", game.getScore());
    }

    @Test
    @DisplayName("Mock de TennisGame: los puntos no se suman y getScore() devuelve null")
    void mockGameDoesNotExecuteRealBehaviour() {
        // Arrange
        TennisGame game = mock(TennisGame.class);

        // Act
        game.player1Scores();
        game.player1Scores();

        // Assert
        assertNull(game.getScore());
    }

    @Test
    @DisplayName("Spy de ArrayList: tras un add, size() vale 1")
    void spyListExecutesRealBehaviour() {
        // Arrange
        List<String> list = spy(new ArrayList<>());

        // Act
        list.add("Nadal");

        // Assert
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Mock de ArrayList: tras dos add, size() vale 0")
    void mockListDoesNotExecuteRealBehaviour() {
        // Arrange
        List<String> list = mock(ArrayList.class);

        // Act
        list.add("Nadal");
        list.add("Federer");

        // Assert
        assertEquals(0, list.size());
    }
}
