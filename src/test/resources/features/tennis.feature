Feature: Marcador de un juego de tenis

  Scenario: Empieza el juego
    Given un juego nuevo
    Then el marcador es "love-love"

  @pendiente
  Scenario: Ventaja tras deuce
    Given un juego nuevo
    When el jugador 1 gana 3 puntos
    And el jugador 2 gana 3 puntos
    And el jugador 1 gana 1 punto
    Then el marcador es "advantage player 1"

  Scenario Outline: Marcadores del juego
    Given un juego nuevo
    When el jugador 1 gana <p1> puntos
    And el jugador 2 gana <p2> puntos
    Then el marcador es "<marcador>"

    Examples:
      | p1 | p2 | marcador     |
      | 0  | 0  | love-love    |
      | 1  | 0  | fifteen-love |
      | 3  | 3  | deuce        |

    @pendiente
    Examples:
      | p1 | p2 | marcador           |
      | 4  | 3  | advantage player 1 |
      | 5  | 3  | player 1 wins      |
