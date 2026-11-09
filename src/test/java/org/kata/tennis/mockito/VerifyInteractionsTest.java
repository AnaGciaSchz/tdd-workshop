package org.kata.tennis.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kata.tennis.HawkEye;
import org.kata.tennis.HawkEyeUnavailableException;
import org.kata.tennis.Scoreboard;
import org.kata.tennis.TennisGame;
import org.kata.tennis.TennisMatch;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("4. Verificar interacciones")
class VerifyInteractionsTest {

    private final HawkEye hawkEye = mock(HawkEye.class);
    private final Scoreboard scoreboard = mock(Scoreboard.class);
    private final TennisMatch match = new TennisMatch(new TennisGame(), hawkEye, scoreboard);

    @Test
    @DisplayName("verify: el marcador se mostró con el resultado exacto")
    void verifyMethodWasCalledWithArguments() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(true);

        // Act
        match.resolvePlayerOneShot();

        // Assert
        verify(scoreboard).display("fifteen-love");
    }

    @Test
    @DisplayName("times(3): tras tres golpes, el marcador se actualiza exactamente tres veces")
    void verifyExactNumberOfCalls() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(true);

        // Act
        match.resolvePlayerOneShot();
        match.resolvePlayerOneShot();
        match.resolvePlayerOneShot();

        // Assert
        verify(scoreboard, times(3)).display(anyString());
    }

    @Test
    @DisplayName("never(): si el ojo de halcón falla, el marcador no se actualiza nunca")
    void verifyMethodWasNeverCalled() {
        // Arrange
        when(hawkEye.isBallIn()).thenThrow(new HawkEyeUnavailableException("Ojo de halcón sin conexión"));

        // Act
        assertThrows(HawkEyeUnavailableException.class, match::resolvePlayerOneShot);

        // Assert
        verify(scoreboard, never()).display(anyString());
    }

    @Test
    @DisplayName("atLeast(2): tras dos golpes, se consultó al ojo de halcón al menos dos veces")
    void verifyMinimumNumberOfCalls() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(true);

        // Act
        match.resolvePlayerOneShot();
        match.resolvePlayerOneShot();

        // Assert
        verify(hawkEye, atLeast(2)).isBallIn();
    }

    @Test
    @DisplayName("atMost(3): tras dos golpes, el marcador se actualizó como mucho tres veces")
    void verifyMaximumNumberOfCalls() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(true);

        // Act
        match.resolvePlayerOneShot();
        match.resolvePlayerOneShot();

        // Assert
        verify(scoreboard, atMost(3)).display(anyString());
    }
}
