package org.kata.tennis.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kata.tennis.HawkEye;
import org.kata.tennis.Scoreboard;
import org.kata.tennis.TennisGame;
import org.kata.tennis.TennisMatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("7. Stub frente a Mock aplicado a un servicio")
class StubVsMockTest {

    private final HawkEye hawkEye = mock(HawkEye.class);
    private final Scoreboard scoreboard = mock(Scoreboard.class);
    private final TennisMatch match = new TennisMatch(new TennisGame(), hawkEye, scoreboard);

    @Test
    @DisplayName("Stub (estado): el ojo de halcón dice que entra y comprobamos el marcador resultante")
    void stubChecksResultingState() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(true);

        // Act
        match.resolvePlayerOneShot();

        // Assert
        assertEquals("fifteen-love", match.score());
    }

    @Test
    @DisplayName("Mock (comportamiento): el ojo de halcón dice que entra y comprobamos que el partido envió el " +
            "marcador al panel")
    void mockChecksInteractionWithDependency() {
        // Arrange
        when(hawkEye.isBallIn()).thenReturn(true);

        // Act
        match.resolvePlayerOneShot();

        // Assert
        verify(scoreboard).display("fifteen-love");
    }
}
