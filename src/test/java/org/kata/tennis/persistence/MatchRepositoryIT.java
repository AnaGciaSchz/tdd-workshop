// Ejemplo ilustrativo: la kata de tenis no tiene base de datos. Este test muestra cómo se probaría
// la persistencia si la tuviera, levantando un PostgreSQL real en Docker con Testcontainers.
package org.kata.tennis.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@DisplayName("Persistencia de partidos con PostgreSQL (Testcontainers)")
class MatchRepositoryIT {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16");

    @Test
    @DisplayName("Guarda el resultado de un partido terminado")
    void guardaElResultadoDeUnPartido() throws SQLException {
        // Arrange
        var repo = new MatchRepository(
                postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());

        // Act
        repo.save("Player 1", "Player 2", "Player 1 wins");

        // Assert
        assertEquals(1, repo.count());
    }
}
