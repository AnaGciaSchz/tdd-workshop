# TDD Workshop

### **Beneficios de Test-Driven Development (TDD)**

1. **Código más confiable** – Detecta errores temprano y reduce bugs en producción.
2. **Mejor diseño y arquitectura** – Fomenta un código modular, desacoplado y mantenible.
3. **Facilita el refactoring** – Permite mejorar el código sin miedo a romper funcionalidades.
4. **Documentación viva** – Los tests sirven como especificación del comportamiento del sistema.
5. **Menos necesidad de depuración** – Se reducen las pruebas manuales y la necesidad de usar el debugger.
6. **Desarrollo más rápido a largo plazo** – Aunque al principio es más lento, evita problemas costosos en el futuro.
7. **Mejor cobertura de pruebas** – Se garantiza que cada unidad de código tenga al menos un test.
8. **Mayor confianza en el código** – Facilita cambios y nuevas funcionalidades sin introducir errores inesperados.
9. **Código más simple y limpio** – Evita escribir código innecesario al centrarse solo en lo que es probado.
10. **Fomenta el pensamiento crítico** – Obliga a definir bien los requisitos antes de escribir código.

## Ejemplos de Mockito con la kata de Tennis

Los ejemplos están en `src/test/java/org/kata/tennis/mockito`. Hay una clase por concepto y conviene verlas en este orden:

| # | Clase de test | Concepto que enseña |
|---|---|---|
| 1 | `TestDoublesTest` | Los cinco test doubles: **dummy**, **stub**, **spy**, **mock** y **fake** (`InMemoryScoreboard`, escrito a mano sin Mockito) |
| 2 | `CreatingMocksTest` | Crear un mock con `mock(Clase.class)` y con `@ExtendWith(MockitoExtension.class)` + `@Mock` |
| 3 | `StubbingTest` | Configurar respuestas con `when(...).thenReturn(...)` y `when(...).thenThrow(...)` + `assertThrows` |
| 4 | `VerifyInteractionsTest` | Verificar interacciones con `verify`, `times(n)`, `never()`, `atLeast(n)` y `atMost(n)` |
| 5 | `SpyTest` | Un spy conserva el comportamiento real del objeto y además registra las llamadas |
| 6 | `SpyVsMockTest` | Mismo escenario con spy y con mock: el mock no ejecuta el comportamiento real y el spy sí (con `TennisGame` y con `ArrayList`) |
| 7 | `StubVsMockTest` | Stub para comprobar el **estado** frente a mock para comprobar el **comportamiento** |

### Dominio de los ejemplos

`TennisGame` no depende de nada, así que no hay nada que mockear. Para los ejemplos se añade `TennisMatch`, que resuelve cada golpe del jugador 1 con dos colaboradores propios del tenis:

- **`HawkEye`** (ojo de halcón): dice si la bola ha entrado (`isBallIn()`). Si entra, el punto es del jugador 1; si sale, del jugador 2. Es una dependencia que **devuelve datos**, ideal para stubs, y puede fallar con `HawkEyeUnavailableException`, ideal para `thenThrow`.
- **`Scoreboard`** (marcador del estadio): muestra el resultado tras cada punto (`display(score)`). Es una dependencia que **recibe órdenes** y no devuelve nada, ideal para mocks y `verify`.

Para ejecutar todos los tests: `mvn test`.
