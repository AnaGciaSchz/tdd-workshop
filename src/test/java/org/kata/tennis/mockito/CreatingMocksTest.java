package org.kata.tennis.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kata.tennis.HawkEye;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@DisplayName("2. Crear un mock")
class CreatingMocksTest {

    @Mock
    private HawkEye annotatedHawkEye;

    @Test
    @DisplayName("Con mock(Clase.class): sin configurar, devuelve el valor por defecto (false)")
    void createMockWithMockMethod() {
        // Arrange
        HawkEye hawkEye = mock(HawkEye.class);

        // Act
        boolean ballIn = hawkEye.isBallIn();

        // Assert
        assertFalse(ballIn);
    }

    @Test
    @DisplayName("Con @ExtendWith(MockitoExtension.class) y @Mock: no llamamos a mock(), Mockito rellena el campo con un mock nuevo antes de cada test")
    void createMockWithAnnotation() {
        // Arrange
        HawkEye hawkEye = annotatedHawkEye;

        // Act
        boolean ballIn = hawkEye.isBallIn();

        // Assert
        assertFalse(ballIn);
    }
}
