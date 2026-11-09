package org.kata.tennis.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kata.tennis.HawkEye;
import org.kata.tennis.Scoreboard;
import org.kata.tennis.TennisGame;
import org.kata.tennis.TennisMatch;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("1. Test doubles: dummy, stub, spy, mock y fake")
class TestDoublesTest {

    @Test
    @DisplayName("Dummy: se pasa para poder construir el partido, pero nunca se usa")
    void dummyIsPassedButNeverUsed() {
        // Arrange
        HawkEye dummyHawkEye = mock(HawkEye.class);
        Scoreboard dummyScoreboard = mock(Scoreboard.class);
        TennisMatch match = new TennisMatch(new TennisGame(), dummyHawkEye, dummyScoreboard);

        // Act
        String score = match.score();

        // Assert
        assertEquals("love-love", score);
    }

    @Test
    @DisplayName("Stub: el ojo de halcón devuelve una respuesta predefinida")
    void stubReturnsPredefinedAnswer() {
        // Arrange
        HawkEye stubHawkEye = mock(HawkEye.class);
        when(stubHawkEye.isBallIn()).thenReturn(true);
        TennisMatch match = new TennisMatch(new TennisGame(), stubHawkEye, mock(Scoreboard.class));

        // Act
        match.resolvePlayerOneShot();

        // Assert
        assertEquals("fifteen-love", match.score());
    }

    @Test
    @DisplayName("Spy: envuelve un juego real y registra las llamadas que recibe")
    void spyWrapsRealObjectAndRecordsCalls() {
        // Arrange
        TennisGame spyGame = spy(new TennisGame());

        // Act
        spyGame.player1Scores();

        // Assert
        verify(spyGame).player1Scores();
    }

    @Test
    @DisplayName("Mock: comprobamos que el partido envió el marcador al panel")
    void mockVerifiesExpectedInteraction() {
        // Arrange
        HawkEye stubHawkEye = mock(HawkEye.class);
        when(stubHawkEye.isBallIn()).thenReturn(true);
        Scoreboard mockScoreboard = mock(Scoreboard.class);
        TennisMatch match = new TennisMatch(new TennisGame(), stubHawkEye, mockScoreboard);

        // Act
        match.resolvePlayerOneShot();

        // Assert
        verify(mockScoreboard).display("fifteen-love");
    }

    @Test
    @DisplayName("Fake: un marcador en memoria escrito a mano que funciona de verdad")
    void fakeIsAWorkingHandWrittenImplementation() {
        // Arrange
        HawkEye ballAlwaysIn = () -> true;
        InMemoryScoreboard fakeScoreboard = new InMemoryScoreboard();
        TennisMatch match = new TennisMatch(new TennisGame(), ballAlwaysIn, fakeScoreboard);

        // Act
        match.resolvePlayerOneShot();
        match.resolvePlayerOneShot();

        // Assert
        assertEquals(List.of("fifteen-love", "thirty-love"), fakeScoreboard.displayedScores());
    }
}
