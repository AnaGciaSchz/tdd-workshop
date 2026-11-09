package org.kata.tennis.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kata.tennis.HawkEye;
import org.kata.tennis.HawkEyeUnavailableException;
import org.kata.tennis.Scoreboard;
import org.kata.tennis.TennisGame;
import org.kata.tennis.TennisMatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("3. Stubbing: configurar respuestas")
class StubbingTest {

    private final HawkEye hawkEye = mock(HawkEye.class);
    private final TennisMatch match = new TennisMatch(new TennisGame(), hawkEye, mock(Scoreboard.class));

    @Test
    @DisplayName("thenReturn(true): la bola entra y el punto es para el jugador 1")
    void thenReturnBallInGivesPointToPlayerOne() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(true);

        // Act
        match.resolvePlayerOneShot();

        // Assert
        assertEquals("fifteen-love", match.score());
    }

    @Test
    @DisplayName("thenReturn(false): la bola sale y el punto es para el jugador 2")
    void thenReturnBallOutGivesPointToPlayerTwo() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(false);

        // Act
        match.resolvePlayerOneShot();

        // Assert
        assertEquals("love-fifteen", match.score());
    }

    @Test
    @DisplayName("thenThrow: si el ojo de halcón falla, el partido propaga la excepción")
    void thenThrowPropagatesHawkEyeFailure() {
        // Arrange
        when(hawkEye.isBallIn()).thenThrow(new HawkEyeUnavailableException("Ojo de halcón sin conexión"));

        // Act
        HawkEyeUnavailableException exception = assertThrows(HawkEyeUnavailableException.class, match::resolvePlayerOneShot);

        // Assert
        assertEquals("Ojo de halcón sin conexión", exception.getMessage());
    }
}
