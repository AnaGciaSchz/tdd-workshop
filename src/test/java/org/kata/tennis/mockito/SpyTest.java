package org.kata.tennis.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kata.tennis.HawkEye;
import org.kata.tennis.Scoreboard;
import org.kata.tennis.TennisGame;
import org.kata.tennis.TennisMatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("5. Spy: objeto real que además registra las llamadas")
class SpyTest {

    private final TennisGame spyGame = spy(new TennisGame());
    private final HawkEye hawkEye = mock(HawkEye.class);
    private final TennisMatch match = new TennisMatch(spyGame, hawkEye, mock(Scoreboard.class));

    @Test
    @DisplayName("Conserva el comportamiento real: el juego espiado sigue contando los puntos")
    void spyKeepsRealBehaviour() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(true);

        // Act
        match.resolvePlayerOneShot();

        // Assert
        assertEquals("fifteen-love", match.score());
    }

    @Test
    @DisplayName("Registra las llamadas: podemos verificar que el partido sumó el punto al jugador 1")
    void spyRecordsCalls() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(true);

        // Act
        match.resolvePlayerOneShot();

        // Assert
        verify(spyGame).player1Scores();
    }
}
